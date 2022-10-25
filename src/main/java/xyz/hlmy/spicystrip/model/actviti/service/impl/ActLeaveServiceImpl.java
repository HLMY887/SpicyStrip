package xyz.hlmy.spicystrip.model.actviti.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.transaction.annotation.Transactional;
import xyz.hlmy.spicystrip.common.Constant;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.common.Snowflake;
import xyz.hlmy.spicystrip.model.actviti.dto.LeveDto;
import xyz.hlmy.spicystrip.model.actviti.dto.TaskDto;
import xyz.hlmy.spicystrip.model.actviti.entity.ActLeave;
import xyz.hlmy.spicystrip.model.actviti.mapper.ActLeaveMapper;
import xyz.hlmy.spicystrip.model.actviti.mapper.ActModelMapper;
import xyz.hlmy.spicystrip.model.actviti.service.ActLeaveService;
import org.springframework.stereotype.Service;
import xyz.hlmy.spicystrip.model.actviti.service.ActProcessService;
import xyz.hlmy.spicystrip.util.StrUtil;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;


/**
 * @author lipenghui
 * @description 针对表【act_leave】的数据库操作Service实现
 * @createDate 2022-10-21 16:36:00
 */
@Service
public class ActLeaveServiceImpl extends ServiceImpl<ActLeaveMapper, ActLeave> implements ActLeaveService {

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private RuntimeService runtimeService;


    @Resource
    private ActLeaveMapper actLeaveMapper;

    @Resource
    private TaskService taskService;


    /**
     * 启动请假流程
     *
     * @param dto
     * @return
     */
    @Transactional
    @Override
    public R startLeveProcess(LeveDto dto) {
        if (StrUtil.isEmpty(dto)) return R.err(400, "请假内容不能为空");
        HashMap<String, Object> variables = new HashMap<>();
        ActLeave actLeave = new ActLeave();
        Snowflake actSnowflake = new Snowflake();
        actLeave.setLeaveName(dto.getTile()).setLeaveDay(dto.getDay()).setLeaveReason(dto.getReason()).setId(actSnowflake.nextId());
        variables.put("userID", "李四");
        try {
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(dto.getDeploy()).singleResult();
            String processDefinitionId = processDefinition.getId();
            runtimeService.startProcessInstanceById(processDefinitionId, String.valueOf(actSnowflake.nextId()), variables);
            actLeave.setStatus(Constant.STATE_LEAVE_INAPPROVAL);
            actLeaveMapper.insert(actLeave);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.toString());
            return R.err(400, "流程启动失败");
        }
    }

    /**
     * @param taskId
     * @return
     */
    @Override
    public R completeTask(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        //提交任务
        taskService.complete(taskId);
        ProcessInstance processInstance = this.runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        return R.ok();
    }

    /**
     * 高级用户
     *
     * @param dto
     * @return
     */
    @Override
    public R submitTask(TaskDto dto) {
        //判断是否同意
        String comment = StrUtil.isEmpty(dto.getComment()) ? Constant.FLAG_OK : dto.getComment();
        //拿到当前任务
        Task task = taskService.createTaskQuery().taskId(dto.getTask()).singleResult();
        //添加意见
        taskService.addComment(dto.getTask(), task.getProcessInstanceId(), comment);
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("flag", comment);
        //提交任务
        taskService.complete(dto.getTask(), variables);
        return R.ok();
    }
}




