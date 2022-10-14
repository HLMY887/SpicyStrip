package xyz.hlmy.spicystrip.model.actviti.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.*;
import org.activiti.engine.repository.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.dto.DelProcessModelDto;
import xyz.hlmy.spicystrip.model.actviti.dto.ModelDto;
import xyz.hlmy.spicystrip.model.actviti.dto.ProcessQueryDTo;
import xyz.hlmy.spicystrip.model.actviti.dto.SaveProcessDto;
import xyz.hlmy.spicystrip.model.actviti.mapper.ActivityMapper;
import xyz.hlmy.spicystrip.model.actviti.service.WorkFlowService;
import xyz.hlmy.spicystrip.model.actviti.vo.ProcessModelVO;
import xyz.hlmy.spicystrip.util.PageUtil;
import xyz.hlmy.spicystrip.util.StrUtil;

import javax.annotation.Resource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class WorkFlowServiceImpl implements WorkFlowService {

    private Logger log = Logger.getLogger(String.valueOf(WorkFlowServiceImpl.class));
    @Resource
    private RepositoryService repositoryService;

    @Resource
    private TaskService taskService;

    @Resource
    private HistoryService historyService;

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private ActivityMapper activityMapper;

    /**
     * 检索流程列表
     *
     * @param dto 参数
     * @return IPage
     */
    @Override
    public R getProcesses(ProcessQueryDTo dto) {
        QueryWrapper<Object> queryWrapper = new QueryWrapper<>();
        if (!StrUtil.isEmpty(dto.getModelName())) {
            queryWrapper.like("rm.NAME_", dto.getModelName());
        }
        if (!StrUtil.isEmpty(dto.getProcessName())) {
            queryWrapper.like("rp.NAME_", dto.getProcessName());
        }
        queryWrapper.orderBy(true, false, "rm.CREATE_TIME_", "rm.DEPLOYMENT_ID_");
        List<ProcessModelVO> pageData = PageUtil.getPageData(dto.getPageInfoDto(), activityMapper.listProcessModels(queryWrapper));
        if (pageData.size() != 0) {
            return R.page(pageData, pageData.size());
        }
        return R.err(400, "未检索到数据");
    }

    /**
     * 保存流程模型
     *
     * @param dto
     * @return
     */
    @Transactional
    @Override
    public R saveProcessModel(ModelDto dto) {
        try {
            Model model = repositoryService.newModel();
            //模型设置
            ObjectNode modelNode = objectMapper.createObjectNode();
            modelNode.put(ModelDataJsonConstants.MODEL_NAME, dto.getModelName());
            modelNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, dto.getDescription());
            modelNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
            model.setName(dto.getModelName());
            model.setKey(dto.getProcessId());
            model.setCategory(dto.getCategory());
            model.setMetaInfo(modelNode.toString());
            //完善模型设置
            ObjectNode editorNode = objectMapper.createObjectNode();
            ObjectNode stencilSetNode = objectMapper.createObjectNode();
            ObjectNode properties = objectMapper.createObjectNode();
            stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
            editorNode.replace("stencilset", stencilSetNode);
            properties.put("process_id", dto.getProcessId());
            editorNode.replace("properties", properties);
            repositoryService.addModelEditorSource(model.getId(), editorNode.toString().getBytes(StandardCharsets.UTF_8));
            return R.ok(model.getId());
        } catch (Exception e) {
            return R.err(400, "创建模型失败");
        }
    }

    /**
     * 批量删除流程模型
     *
     * @param dto 集合
     * @return R
     */
    @Override
    public R batchDeleteProcessModels(DelProcessModelDto dto) {
        try {
            //当单删和批量删除的内容未空时
            if (StrUtil.isEmpty(dto.getModelId()) && StrUtil.isSizeEmpty(dto.getModelIds())) {
                return R.err(400, "请选择要删除的流程模型");
            }
            if (!StrUtil.isEmpty(dto.getModelId())) {
                DeleteProcessModel(dto.getModelId());
            } else if (!StrUtil.isEmpty(dto.getModelIds())) {
                if (dto.getModelIds().size() > 0) {
                    dto.getModelIds().forEach(this::DeleteProcessModel);
                }
                return R.err(400, "请选择要删除的流程模型");
            }
            return R.ok();
        } catch (Exception e) {
            return R.err(400, "删除失败");
        }
    }

    /**
     * 我的流程
     *
     * @param dto 参数
     * @return R
     */
    @Override
    public R getMyProcessList(ProcessQueryDTo dto) {
        QueryWrapper<Object> queryWrapper = new QueryWrapper<>();
        if (!StrUtil.isEmpty(dto.getUsername())) {
            // TODO  根据用户获取专属流程
        }
        // TODO 查询条件
        if (!StrUtil.isEmpty(dto.getProcessName())) {
            queryWrapper.like("rp.NAME_", dto.getProcessName());
        }
        queryWrapper.isNotNull("rm.DEPLOYMENT_ID_").orderBy(true, false, "rm.CREATE_TIME_", "rm.KEY_");
        List<ProcessModelVO> processModelVOS = activityMapper.listProcessModels(queryWrapper);
        if (processModelVOS.size() == 0) {
            return R.err(400, "未检索到数据");
        }
        List<ProcessModelVO> pageData = PageUtil.getPageData(dto.getPageInfoDto(), processModelVOS);
        return R.ok(pageData);
    }

    /**
     * 删除
     *
     * @param modelId
     */
    @Transactional
    public void DeleteProcessModel(String modelId) {
        ModelQuery modelQuery = repositoryService.createModelQuery().modelId(modelId);
        Model model = modelQuery.singleResult();
        final String deploymentId = model.getDeploymentId();
        // 已发布需要多删除流程定义和流程发布表
        if (!StrUtil.isEmpty(deploymentId)) {
            repositoryService.deleteDeployment(deploymentId);
        }
        // 删除流程模型表
        repositoryService.deleteModel(modelId);
    }

    /**
     * 导入
     *
     * @param file 当前文件
     */
    @Override
    public void importProcessModel(InputStream file) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));
            String json = reader.lines().collect(Collectors.joining(System.getProperty("line.separator")));
            JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(json);
            JSONArray processes = (JSONArray) jsonObject.get("processes");
            processes.forEach(process -> {
                JSONObject obj = (JSONObject) process;
                String modelId = obj.get("id").toString();
                Model modelEntity = repositoryService.getModel(modelId);
                if (modelEntity == null) {
                    modelEntity = repositoryService.newModel();
                }
                // 新增或更新模型表
                modelEntity.setName(obj.get("name").toString());
                modelEntity.setKey(obj.get("key").toString());
                modelEntity.setMetaInfo(obj.get("metaInfo").toString());
                modelEntity.setVersion((Integer) obj.get("version"));   // todo version 保存无效？
                repositoryService.saveModel(modelEntity);
                // 新增或更新二进制数据
                byte[] modelEditorSources = obj.get("editorSource").toString().getBytes(StandardCharsets.UTF_8);
                byte[] modelEditorSourceExts = obj.get("editorSourceExt").toString().getBytes(StandardCharsets.UTF_8);
                repositoryService.addModelEditorSource(modelEntity.getId(), modelEditorSources);
                repositoryService.addModelEditorSourceExtra(modelEntity.getId(), modelEditorSourceExts);
                log.info("成功导入或更新流程" + modelEntity.getName());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 驳回任务
     *
     * @param taskId task id
     * @return
     */
    @Override
    public R RejectTask(String taskId) {
        return null;
    }

    @Override
    public R getProcessesList() {
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> listPage = processDefinitionQuery.listPage(0, 10);
        Map<Object, Object> processList = new HashMap<>();
        for (ProcessDefinition processDefinition : listPage) {
            processList.put("id", processDefinition.getId());
            processList.put("category", processDefinition.getCategory());
            processList.put("name", processDefinition.getName());
            processList.put("key", processDefinition.getKey());
            processList.put("description", processDefinition.getDescription());
            processList.put("version", processDefinition.getVersion());
        }
        return R.page(processList, processDefinitionQuery.count());
    }

    @Override
    public R deploy(String modelId) {
        String modelName = "", processName = "";
        try {
            // 获取模型
            Model modelData = repositoryService.getModel(modelId);
            modelName = modelData.getName();
            byte[] bytes = repositoryService.getModelEditorSource(modelData.getId());
            if (bytes == null) {
                throw new Exception("模型数据为空，请先设计流程并成功保存，再进行发布。");
            }
            JsonNode modelNode = new ObjectMapper().readTree(bytes);
            BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
            if (model.getProcesses().size() == 0) {
                throw new Exception("数据模型不符要求，请至少设计一条主线流程。");
            }
            byte[] bpmnBytes = new BpmnXMLConverter().convertToXML(model);
            //发布流程
            String processSourceName = modelName + ".bpmn20.xml";
            Deployment deployment = repositoryService.createDeployment().name(modelName).addString(processSourceName, new String(bpmnBytes, StandardCharsets.UTF_8)).deploy();
            return R.ok(deployment.getId());
        } catch (Exception e) {
            return R.err(400, "发布失败");
        }
    }

    @Override
    public R deployTest(InputStream file, String name) {
        Deployment deployment = repositoryService.createDeployment().addInputStream(name, file).deploy();
        return R.ok(deployment.toString());
    }

    /**
     * @param deployKey
     * @return
     */
    @Override
    public R start(String deployKey) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = engine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(deployKey);
        return R.ok(processInstance.toString());
    }


    /**
     * @param dto
     * @return
     */
    @Override
    public R saveProcess(SaveProcessDto dto) {
        return null;
    }

}
