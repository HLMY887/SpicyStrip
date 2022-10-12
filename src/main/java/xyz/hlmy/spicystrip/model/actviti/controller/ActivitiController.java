package xyz.hlmy.spicystrip.model.actviti.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.hlmy.spicystrip.model.actviti.dto.DelProcessModelDto;
import xyz.hlmy.spicystrip.model.actviti.dto.DeployProcessDto;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.dto.ModelDto;
import xyz.hlmy.spicystrip.model.actviti.dto.ProcessQueryDTo;
import xyz.hlmy.spicystrip.model.actviti.service.WorkFlowService;
import xyz.hlmy.spicystrip.util.ActivitiUtil;

import javax.annotation.Resource;

@RestController
@RequestMapping("/act")
public class ActivitiController {

    @Resource
    private WorkFlowService workFlowService;

    /**
     * 部署 (不建议使用)
     *
     * @param dto
     * @return
     */
    @GetMapping("/bpmn")
    public R deployProcessBPMN(@RequestBody DeployProcessDto dto) {
        return ActivitiUtil.deployProcess(dto.getFilePath(), dto.getFileImage(), dto.getProcessName());
    }

    /**
     * 部署 不建议使用
     *
     * @param file
     * @param processName
     * @return
     */
    @PostMapping("/zip")
    public R deployProcessZip(@RequestParam("file") MultipartFile file, @RequestParam("processName") String processName) {
        return ActivitiUtil.deployProcess(file, processName);
    }

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
    public R getMyProcessList(ProcessQueryDTo dto) {
        return workFlowService.getMyProcessList(dto);
    }
}
