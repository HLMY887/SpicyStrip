package xyz.hlmy.spicystrip.model.actviti.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ModelQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import xyz.hlmy.spicystrip.common.Constant;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.common.Snowflake;
import xyz.hlmy.spicystrip.model.actviti.dto.ModelDTO;
import xyz.hlmy.spicystrip.model.actviti.dto.MyTodoDTO;
import xyz.hlmy.spicystrip.model.actviti.dto.ProcessQuery;
import xyz.hlmy.spicystrip.model.actviti.entity.ActLeave;
import xyz.hlmy.spicystrip.model.actviti.entity.ActModel;
import xyz.hlmy.spicystrip.model.actviti.entity.ActProcess;
import xyz.hlmy.spicystrip.model.actviti.mapper.ActLeaveMapper;
import xyz.hlmy.spicystrip.model.actviti.service.ActModelService;
import xyz.hlmy.spicystrip.model.actviti.mapper.ActModelMapper;
import org.springframework.stereotype.Service;
import xyz.hlmy.spicystrip.model.actviti.service.ActProcessService;
import xyz.hlmy.spicystrip.model.actviti.service.ActService;
import xyz.hlmy.spicystrip.model.actviti.vo.MyProListVO;
import xyz.hlmy.spicystrip.model.actviti.vo.MyTodoVO;
import xyz.hlmy.spicystrip.model.actviti.vo.ProcessModelVO;
import xyz.hlmy.spicystrip.model.sys.entity.SysUser;
import xyz.hlmy.spicystrip.util.Util;
import xyz.hlmy.spicystrip.util.StrUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.activiti.editor.constants.ModelDataJsonConstants.*;

/**
 * @author lipenghui
 * @description ????????????ACT_MODEL(??????????????????)?????????????????????Service??????
 * @createDate 2022-10-20 14:14:34
 */
@Slf4j
@Service
public class ActModelServiceImpl extends ServiceImpl<ActModelMapper, ActModel> implements ActModelService {
    @Resource
    private RepositoryService repositoryService;

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private ActProcessService actProcessService;

    @Resource
    private ActModelMapper actModelMapper;

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private HistoryService historyService;
    @Resource
    private ActLeaveMapper actLeaveMapper;

    @Resource
    private TaskService taskService;

    @Resource
    private ActService actService;

    /**
     * ????????????
     *
     * @param actModel ????????????
     * @return R
     */
    @Override
    @Transactional
    public R insertPro(ModelDTO actModel) {
        log.info(actModel.toString());
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.replace("stencilset", stencilSetNode);

        Model model = repositoryService.newModel();
        ObjectNode modelObjectNode = objectMapper.createObjectNode();
        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, actModel.getName());
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
        modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, actModel.getDescription());
        model.setMetaInfo(modelObjectNode.toString());
        model.setName(actModel.getName());
        model.setKey(actModel.getKey());
        // ????????????
        repositoryService.saveModel(model);
        repositoryService.addModelEditorSource(model.getId(), editorNode.toString().getBytes(StandardCharsets.UTF_8));
        return R.ok();
    }

    /**
     * ????????????
     *
     * @param modelId     ID
     * @param name        ??????
     * @param description ??????
     * @param json_xml    xml
     * @param svg_xml     svg
     * @return R
     */
    @Override
    @Transactional
    public R saveModel(String modelId, String name, String description, String json_xml, String svg_xml) {
        try {
            Model model = repositoryService.getModel(modelId);
            ObjectNode modelJson = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
            modelJson.put(MODEL_NAME, name);
            modelJson.put(MODEL_DESCRIPTION, description);
            model.setMetaInfo(modelJson.toString());
            model.setName(name);
            repositoryService.saveModel(model);
            repositoryService.addModelEditorSource(model.getId(), json_xml.getBytes(StandardCharsets.UTF_8));
            InputStream svgStream = new ByteArrayInputStream(svg_xml.getBytes(StandardCharsets.UTF_8));
            TranscoderInput input = new TranscoderInput(svgStream);
            PNGTranscoder transcoder = new PNGTranscoder();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            TranscoderOutput output = new TranscoderOutput(outStream);
            transcoder.transcode(input, output);
            final byte[] result = outStream.toByteArray();
            repositoryService.addModelEditorSourceExtra(model.getId(), result);
            outStream.close();
            return R.ok();
        } catch (Exception e) {
            log.error("??????????????????", e);
            return R.err(400, "??????");
        }
    }

    /**
     * ??????????????????
     *
     * @return R
     */
    @Override
    public IPage<ProcessModelVO> getModelList() {
        IPage<ProcessModelVO> page = new Page<>(0, 10);
        QueryWrapper<Object> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderBy(true, false, "rm.CREATE_TIME_", "rm.DEPLOYMENT_ID_");
        page = actModelMapper.listProcessModels(queryWrapper, page);
        return page;
    }

    /**
     * ????????????json
     *
     * @param modelId ??????ID
     * @return R
     */
    @Override
    public ObjectNode getModelJson(String modelId) {
        ObjectNode modelNode = null;
        Model model = repositoryService.getModel(modelId);
        if (model != null) {
            try {
                if (StringUtils.isNotEmpty(model.getMetaInfo())) {
                    modelNode = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
                } else {
                    modelNode = objectMapper.createObjectNode();
                    modelNode.put(MODEL_NAME, model.getName());
                }
                modelNode.put(MODEL_ID, model.getId());
                ObjectNode editorJsonNode = (ObjectNode) objectMapper.readTree(new String(repositoryService.getModelEditorSource(model.getId()), StandardCharsets.UTF_8));
                modelNode.replace("model", editorJsonNode);
            } catch (Exception e) {

                throw new ActivitiException("Error creating model JSON", e);
            }
        }
        return modelNode;
    }

    /**
     * ??????/????????????
     *
     * @param modelId ??????ID
     * @return R
     */
    @Override
    @Transactional
    public R deployModel(String modelId) {
        try {
            Model modelData = this.repositoryService.getModel(modelId);
            byte[] bytes = this.repositoryService.getModelEditorSource(modelData.getId());
            if (bytes == null) {
                return R.err(400, "???????????????????????????????????????????????????");
            }
            JsonNode modelNode = new ObjectMapper().readTree(bytes);
            BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
            if (model.getProcesses().size() == 0) {
                return R.err(400, "???????????????????????????????????????????????????????????????");
            }
            byte[] bpmnBytes = new BpmnXMLConverter().convertToXML(model);
            //????????????
            String processName = modelData.getName() + ".bpmn20.xml";
            Deployment deployment = repositoryService.createDeployment().name(modelData.getName()).addString(processName, new String(bpmnBytes, StandardCharsets.UTF_8)).deploy();

            Integer version = modelData.getVersion();
            modelData.setVersion(StrUtil.isEmpty(modelData.getDeploymentId()) ? version : version + 1);
            modelData.setDeploymentId(deployment.getId());
            repositoryService.saveModel(modelData);
            List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).list();
            for (ProcessDefinition pd : list) {
                ActProcess actProcess = new ActProcess();
                actProcess.setId(Integer.valueOf(deployment.getId())).setXmlName(pd.getResourceName()).setDiagramName(pd.getDiagramResourceName());
                actProcessService.saveOrUpdate(actProcess);
            }
            return R.ok();
        } catch (Exception e) {
            return R.err(400, "");
        }
    }


    /**
     * ????????????(??????????????????)
     *
     * @param modelId ??????ID
     * @return R
     */
    @Override
    @Transactional
    public R deleteProcess(String modelId) {
        try {
            ModelQuery modelQuery = repositoryService.createModelQuery().modelId(modelId);
            Model model = modelQuery.singleResult();
            final String deploymentId = model.getDeploymentId();
            //??????
            if (!StrUtil.isEmpty(deploymentId)) {
                repositoryService.deleteDeployment(deploymentId);
                actProcessService.removeById(deploymentId);
            }
            // ?????????????????????
            repositoryService.deleteModel(modelId);
            return R.ok();
        } catch (Exception e) {
            log.info(e.toString());
            return R.err(400, "????????????");
        }
    }

    /**
     * ??????????????????????????????
     *
     * @return IPage
     */
    @Override
    public IPage<ProcessModelVO> getDeploymentProcess() {
        IPage<ProcessModelVO> page = new Page<>(0, 10);
        QueryWrapper<Object> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("rm.DEPLOYMENT_ID_");
        wrapper.orderBy(true, false, "rm.CREATE_TIME_", "rm.KEY_");
        page = actModelMapper.listProcessModels(wrapper, page);
        return page;
    }

    /**
     * ?????????????????????????????????????????????
     *
     * @param deploymentId ID
     * @return R
     */
    @Override
    public R startProcess(String deploymentId) {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId).singleResult();
        if (processDefinition.isSuspended()) {
            return R.err(400, "?????????????????????????????????????????????????????????");
        }
        //???????????????ID
        String processDefinitionId = processDefinition.getId();

        //????????????ID
        Snowflake snowflake = new Snowflake();
        long nextId = snowflake.nextId();
        HashMap<String, Object> variables = new HashMap<>();
        SysUser user = Util.getUser();
        try {
            runtimeService.startProcessInstanceById(processDefinitionId, String.valueOf(nextId));
            ActLeave actLeave = new ActLeave();
//            actLeave.setId((int) nextId);
            actLeave.setLeaveDay(2.0);
            actLeave.setLeaveName("??????");
            actLeave.setLeaveReason("??????");
            actLeave.setStatus(Constant.STATE_LEAVE_INAPPROVAL);
            actLeaveMapper.insert(actLeave);
            return R.ok();
        } catch (Exception e) {
            log.error(e.toString());
            return R.err(400, "????????????");
        }
    }

    /**
     * ????????????
     *
     * @param userName ??????????????????
     * @param proName  ????????????
     * @return List
     */
    @Override
    //TODO ?????????
    public ProcessQuery<MyProListVO> myProcessList(String userName, String proName) {
        HistoricProcessInstanceQuery historicProcessInstanceQuery = historyService.createHistoricProcessInstanceQuery();
        //TODO ???????????????????????????(?????????????????????????????????)
        if (!StrUtil.isEmpty(userName)) {
            historicProcessInstanceQuery.startedBy(userName);
        }
        //??????????????????????????????
        if (!StrUtil.isEmpty(proName)) {
            historicProcessInstanceQuery.processDefinitionName(StrUtil.jointLike(proName));
        }
        historicProcessInstanceQuery.orderByProcessInstanceStartTime().desc();
        final ProcessQuery<List<HistoricProcessInstance>> pq = new ProcessQuery<>();
        List<HistoricProcessInstance> historicProcessInstances = pq.listPage(historicProcessInstanceQuery, 10, 0).getData();
        log.info(historicProcessInstances.toString());
        return null;
    }

    /**
     * ????????????
     *
     * @param dto ????????????
     * @return List
     */
    @Override
    public R getMyTodoList(MyTodoDTO dto) {
        TaskQuery taskQuery = taskService.createTaskQuery();
        //??????????????????
        SysUser user = Util.getUser();
        dto.setUsername(user.getUserName());
        if (!StrUtil.isEmpty(dto.getUsername())) {
            taskQuery.taskCandidateOrAssigned(dto.getUsername());
        }
        if (!StrUtil.isEmpty(dto.getTaskName())) {
            taskQuery.taskNameLike(StrUtil.jointLike(dto.getTaskName()));
        }
        if (!StrUtil.isEmpty(dto.getProcessName())) {
            taskQuery.processDefinitionNameLike(StrUtil.jointLike(dto.getProcessName()));
        }
        ProcessQuery<List<Task>> tq = new ProcessQuery<>();
        List<MyTodoVO> myTodoVOS = new ArrayList<>();
        List<Task> tasks = tq.listPage(taskQuery, 1, 10).getData();
        tasks.forEach(task -> {
            MyTodoVO myTodoVO = new MyTodoVO();
            BeanUtil.copyProperties(task, myTodoVO);
            HistoricProcessInstance historicProcessInstance = this.getHistoricProcessInstanceByProcessInstanceId(task.getProcessInstanceId());
            myTodoVO.setProcessName(historicProcessInstance.getName());
            myTodoVO.setStartUser(historicProcessInstance.getStartUserId());
            myTodoVOS.add(myTodoVO);
        });
        return R.page(myTodoVOS, tq.getCount());
    }

    /**
     * ?????????????????????
     *
     * @param processInstanceId ???????????? ID
     * @return HistoricProcessInstance ??????????????????
     */
    @Override
    public HistoricProcessInstance getHistoricProcessInstanceByProcessInstanceId(String processInstanceId) {
        return historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
    }

    /**
     * @param dpyId
     * @return
     */
    @Override
    public ResponseEntity<Object> viewProImage(String dpyId) {
        List<String> names = this.repositoryService.getDeploymentResourceNames(dpyId);
        InputStream stream = null;
        for (String resourceName : names) {
            if (resourceName.endsWith(".png")) {
                stream = repositoryService.getResourceAsStream(dpyId, resourceName);
            }
        }
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100]; //buff???????????????????????????????????????
        int rc = 0;
        try {
            while ((rc = stream.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ???????????????????????????byte[]
        byte[] bytes = swapStream.toByteArray();
        // ????????????????????????????????????
        HttpHeaders header = new HttpHeaders();
        // ????????????????????????(APPLICATION_OCTET_STREAM ????????????????????????)
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // ??????????????????????????????
        header.setContentDispositionFormData("attachment", "saaa.jpg");
        // ??????ResponseEntity??????
        ResponseEntity<Object> entity = new ResponseEntity<Object>(bytes, header, HttpStatus.CREATED);
        return entity;
    }

    /**
     * ???????????????
     *
     * @param processInstanceId
     * @param response
     */
    @Override
    public void processFlowChartImage(String processInstanceId, HttpServletResponse response) {
        try {
            byte[] bytes = actService.getFlowImgByProcInstId(processInstanceId);
            response.setHeader("Content-Type", "image/png");
            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    /**
     * ????????????
     *
     * @param deploymentIds ????????????ID
     * @return R
     */
    @Override
    @Transactional
    public R suspendProcessDefinitionByIds(List<String> deploymentIds) {
        try {
            deploymentIds.forEach(deploymentId -> {
                ProcessDefinition result = repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId).singleResult();
                if (!result.isSuspended()) {
                    repositoryService.suspendProcessDefinitionById(result.getId());
                }
            });
            return R.ok();
        } catch (Exception e) {
            return R.err(400, "????????????");
        }
    }

    /**
     * ????????????
     *
     * @param deploymentIds ????????????ID
     * @return R
     */
    @Override
    public R activationProcess(List<String> deploymentIds) {
        try {
            deploymentIds.forEach(deploymentId -> {
                ProcessDefinition result = repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId).singleResult();
                if (result.isSuspended()) {
                    repositoryService.activateProcessDefinitionById(result.getId());
                }
            });
            return R.ok();
        } catch (Exception e) {
            return R.err(400, "????????????");
        }
    }
}




