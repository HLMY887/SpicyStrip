package xyz.hlmy.spicystrip.model.actviti.controller;

import org.springframework.web.bind.annotation.*;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.controller.BaseController;
import xyz.hlmy.spicystrip.model.actviti.dto.LeveDto;

import xyz.hlmy.spicystrip.model.actviti.dto.TaskDto;
import xyz.hlmy.spicystrip.model.actviti.service.ActLeaveService;

import javax.annotation.Resource;


/**
 * 请假流程控制层
 */
@RestController
@RequestMapping("/leve")
public class LeveController extends BaseController {

    @Resource
    private ActLeaveService actLeaveService;


    /**
     * 请假流程启动
     *
     * @param dto 返回参数值
     * @return R
     */
    @PostMapping("/deploy")
    public R startLeveProcess(@RequestBody LeveDto dto) {
        log.info("ActModelController startLeveProcess START");
        R r = actLeaveService.startLeveProcess(dto);
        log.info("ActModelController startLeveProcess END");
        return r;
    }

    /**
     * 普通用户提交
     *
     * @param taskId 任务ID
     * @return R
     */
    @GetMapping("/task/{taskId}/complete")
    public R completeTask(@PathVariable String taskId) {
        log.info("ActModelController completeTask START");
        R r = actLeaveService.completeTask(taskId);
        log.info("ActModelController completeTask END");
        return r;
    }

    /**
     * 审批人员
     *
     * @param dto
     * @return
     */
    @PostMapping("/task/complete")
    public R submitTask(@RequestBody TaskDto dto) {
        log.info("ActModelController submitTask START");
        R r = actLeaveService.submitTask(dto);
        log.info("ActModelController submitTask END");
        return r;
    }
}
