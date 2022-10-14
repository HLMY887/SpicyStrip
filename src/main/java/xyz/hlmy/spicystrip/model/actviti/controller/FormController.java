package xyz.hlmy.spicystrip.model.actviti.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.entity.ActForm;
import xyz.hlmy.spicystrip.model.actviti.service.ActFormService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/act/from")
public class FormController {

    @Resource
    private ActFormService actFormService;


    /**
     * 创建表单
     *
     * @param form
     * @return
     */
    @PostMapping("/save")
    public R saveForm(ActForm form) {
        return actFormService.saveForm(form);
    }

}
