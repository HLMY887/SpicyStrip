package xyz.hlmy.spicystrip.model.actviti.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.hlmy.spicystrip.model.actviti.dto.DelProcessModelDto;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.dto.ProcessQueryDTo;
import xyz.hlmy.spicystrip.model.actviti.service.WorkFlowService;


import javax.annotation.Resource;


@RestController
@RequestMapping("/act")
public class ActivitiController {

    @Resource
    private WorkFlowService workFlowService;

    /**
     * 批量删除
     *
     * @return
     */
    @PostMapping("/del")
    public R batchDeleteProcessModels(@RequestBody DelProcessModelDto dto) {
        return workFlowService.batchDeleteProcessModels(dto);
    }


    /**
     * 我的流程
     *
     * @param dto
     * @return
     */
    @GetMapping("/my/list")
    public R getMyProcessList(@RequestBody ProcessQueryDTo dto) {
        return workFlowService.getMyProcessList(dto);
    }

    /**
     * 导入
     *
     * @param file
     * @return
     */
    @PostMapping("/import")
    public R importProcessModel(@RequestParam("file") MultipartFile file) {
        try {
            System.out.println("上传文件的名字--{}" + file.getOriginalFilename());
            workFlowService.importProcessModel(file.getInputStream());
            return R.ok();
        } catch (Exception e) {
            return R.err(400, "导入失败");
        }
    }

    /**
     * 驳回
     *
     * @param taskId
     * @return
     */
    @PostMapping("/task/reject")
    public R RejectTask(@PathVariable String taskId) {
        return workFlowService.RejectTask(taskId);
    }

    /**
     * 流程定义列表
     *
     * @return
     */
    @GetMapping("/pro/list")
    public R getList() {
        return workFlowService.getProcessesList();
    }

    /**
     * 模型部署
     */
    @PostMapping(value = "deploy/{modelId}")
    public R deploy(@PathVariable String modelId) {
        return R.ok(workFlowService.deploy(modelId));
    }


}
