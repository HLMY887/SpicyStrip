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
import org.springframework.stereotype.Service;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.dto.ModelDto;
import xyz.hlmy.spicystrip.model.actviti.dto.ProcessQueryDTo;
import xyz.hlmy.spicystrip.model.actviti.mapper.ActivityMapper;
import xyz.hlmy.spicystrip.model.actviti.service.WorkFlowService;
import xyz.hlmy.spicystrip.model.actviti.vo.ProcessModelVO;
import xyz.hlmy.spicystrip.util.StrUtil;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Service
public class WorkFlowServiceImpl implements WorkFlowService {

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
        IPage<ProcessModelVO> page = new Page<>(dto.getPageInfoDto().getIndex(), dto.getPageInfoDto().getPageSize());
        QueryWrapper<Object> queryWrapper = new QueryWrapper<>();
        if (!StrUtil.isEmpty(dto.getModelName())) {
            queryWrapper.like("rm.NAME_", dto.getModelName());
        }
        if (!StrUtil.isEmpty(dto.getProcessName())) {
            queryWrapper.like("rp.NAME_", dto.getProcessName());
        }
        queryWrapper.orderBy(true, false, "rm.CREATE_TIME_", "rm.DEPLOYMENT_ID_");
        page = activityMapper.listProcessModels(queryWrapper, page);
        if (page.getSize() != 0) {
            return R.ok(page);
        }
        return R.err(400, "未检索到数据");
    }

    /**
     * 保存流程模型
     *
     * @param dto
     * @return
     */
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
}
