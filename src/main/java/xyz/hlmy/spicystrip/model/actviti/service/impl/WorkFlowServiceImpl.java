package xyz.hlmy.spicystrip.model.actviti.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ModelQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.dto.DelProcessModelDto;
import xyz.hlmy.spicystrip.model.actviti.dto.ModelDto;
import xyz.hlmy.spicystrip.model.actviti.dto.ProcessQueryDTo;
import xyz.hlmy.spicystrip.model.actviti.mapper.ActivityMapper;
import xyz.hlmy.spicystrip.model.actviti.service.WorkFlowService;
import xyz.hlmy.spicystrip.model.actviti.vo.ProcessModelVO;
import xyz.hlmy.spicystrip.util.PageUtil;
import xyz.hlmy.spicystrip.util.StrUtil;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;

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
            ObjectNode editorNode = objectMapper.createObjectNode();
            editorNode.put("id", "canvas");
            editorNode.put("resourceId", "canvas");
            ObjectNode stencilSetNode = objectMapper.createObjectNode();
            stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
            editorNode.put("stencilset", stencilSetNode);
            Model model = repositoryService.newModel();
            ObjectNode modelObjectNode = objectMapper.createObjectNode();
            modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, dto.getModelName());
            modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, dto.getDescription());
            model.setMetaInfo(modelObjectNode.toString());
            model.setName(dto.getModelName());
            model.setKey(dto.getModelKey());
            // 保存模型
            repositoryService.saveModel(model);
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
     * @param dto
     * @return
     */
    @Override
    public R getMyProcessList(ProcessQueryDTo dto) {
        return null;
    }


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
}
