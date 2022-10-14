package xyz.hlmy.spicystrip.model.actviti.controller;

import org.springframework.web.bind.annotation.*;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.dto.ModelDto;
import xyz.hlmy.spicystrip.model.actviti.dto.ProcessQueryDTo;
import xyz.hlmy.spicystrip.model.actviti.service.WorkFlowService;

import javax.annotation.Resource;

/**
 * 流程模型的操作
 */
@RestController
@RequestMapping("/model")
public class ModelController {

    @Resource
    private WorkFlowService workFlowService;


    /**
     * 检索流程模型 列表
     *
     * @param dTo 参数
     * @return R
     */
    @GetMapping("/list")
    public R getProcessLists(@RequestBody ProcessQueryDTo dTo) {
        return workFlowService.getProcesses(dTo);
    }

    /**
     * 创建流程模型
     *
     * @param dto 参数
     * @return R
     */
    @PostMapping("/save")
    public R saveProcessModel(@RequestBody ModelDto dto) {
        return workFlowService.saveProcessModel(dto);
    }
}
