package xyz.hlmy.spicystrip.model.actviti.service.impl;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.mapper.ActLeaveMapper;
import xyz.hlmy.spicystrip.model.actviti.service.HolidayService;
import xyz.hlmy.spicystrip.util.StrUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Resource
    private RepositoryService repositoryService;


    @Resource
    private RuntimeService runtimeService;


    @Resource
    private ActLeaveMapper actLeaveMapper;

    @Resource
    private TaskService taskService;


    /**
     * 会签启动流程
     *
     * @param deployId 部署id
     * @return R
     */
    @Override
    public R startProcess(String deployId) {
        //设置申请用户
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("userID", "张三");
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).singleResult();
        String processDefinitionId = processDefinition.getId();
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinitionId, variables);
        //获取到流程
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //设置会签人员
        Map<String, Object> var = new HashMap<>();
        List<String> signList = new ArrayList<>();
        signList.add("李四");
        signList.add("王五");
        signList.add("老刘");
        var.put("signList", signList);
        taskService.complete(task.getId(), var);
        return R.ok();
    }

    /**
     * @param taskId
     * @param result
     * @return
     */
    @Override
    public R completeTask(String taskId, String result) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (result.equals("1")) {
            Map<String, Object> map = new HashMap<>();
            map.put("pass", true);
            taskService.complete(task.getId(), map);
            return R.ok();
        }else {
            Map<String, Object> map = new HashMap<>();
            map.put("pass", false);
            taskService.complete(task.getId(), map);
        }
        return R.ok();
    }

}
