package xyz.hlmy.spicystrip.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.hlmy.spicystrip.actviti.dto.DeployProcessDto;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.util.ActivitiUtil;

@RestController
@RequestMapping("/act")
public class ActivitiController {

    @GetMapping("/bpmn")
    public R deployProcessBPMN(@RequestBody DeployProcessDto dto) {
        return ActivitiUtil.deployProcess(dto.getFilePath(), dto.getFileImage(), dto.getProcessName());
    }

    @PostMapping("/zip")
    public R deployProcessZip(@RequestParam("file") MultipartFile file, @RequestParam("processName") String processName) {
        return ActivitiUtil.deployProcess(file, processName);
    }
}
