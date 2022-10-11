package xyz.hlmy.spicystrip.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hlmy.spicystrip.actviti.dto.DeployProcessDto;
import xyz.hlmy.spicystrip.util.ActivitiUtil;

@RestController
@RequestMapping("/act")
public class ActivitiController {

    @GetMapping("/bpmn")
    public void deployProcessBPMN(@RequestBody DeployProcessDto dto) {
        ActivitiUtil.deployProcess(dto.getFilePath(), dto.getFileImage(), dto.getProcessName());
    }
}
