package xyz.hlmy.spicystrip.model.actviti.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.dto.SaveProcessDto;
import xyz.hlmy.spicystrip.model.actviti.service.WorkFlowService;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 会签
 */
@RestController
@RequestMapping("/act/fy")
public class TaskController {

    @Resource
    private WorkFlowService workFlowService;

    /**
     * 流程图部署
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/deploy")
    public R buShu(@RequestParam("file") MultipartFile file) throws IOException {
        return workFlowService.deployTest(file.getInputStream(), file.getOriginalFilename());
    }

    /**
     * 流程图启动
     *
     * @param deployKey
     * @return
     */
    @PostMapping("/start")
    public R start(@RequestParam("deployKey") String deployKey) {
        return workFlowService.start(deployKey);
    }

    /**
     * 创建流程
     */

    @PostMapping("/save")
    public R saveProcess(@RequestBody SaveProcessDto dto) {
        return workFlowService.saveProcess(dto);
    }
}
