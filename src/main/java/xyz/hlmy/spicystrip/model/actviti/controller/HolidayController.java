package xyz.hlmy.spicystrip.model.actviti.controller;

import org.springframework.web.bind.annotation.*;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.controller.BaseController;
import xyz.hlmy.spicystrip.model.actviti.service.HolidayService;

import javax.annotation.Resource;

/**
 * 会签控制层
 */
@RestController
@RequestMapping("/holiday")
public class HolidayController extends BaseController {

    @Resource
    private HolidayService holidayService;

    /**
     * 会签流程启动
     *
     * @param deployId 部署ID
     * @return R
     */
    @PostMapping("/start/{deployId}")
    public R startProcess(@PathVariable("deployId") String deployId) {
        log.info("HolidayController startProcess START");
        R r = holidayService.startProcess(deployId);
        log.info("ActModelController startProcess END");
        return r;
    }

    @PostMapping("/complete/task")
    public R completeTask(@RequestParam("taskId") String taskId, @RequestParam("result") String result) {
        log.info("HolidayController completeTask START");
        R r = holidayService.completeTask(taskId, result);
        log.info("HolidayController completeTask END ");
        return r;
    }
}
