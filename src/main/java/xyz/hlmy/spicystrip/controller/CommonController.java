package xyz.hlmy.spicystrip.controller;


import org.activiti.engine.ActivitiException;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import xyz.hlmy.spicystrip.model.sys.service.SysUserService;

import javax.annotation.Resource;

import java.io.InputStream;


@Controller
public class CommonController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/editor")
    public ModelAndView editor() {
        return new ModelAndView("/modeler");
    }

    @RequestMapping(value = "/editor/stencilset", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getStencilset() {
        InputStream stencilsetStream = this.getClass().getClassLoader().getResourceAsStream("stencilset.json");
        try {
            assert stencilsetStream != null;
            return IOUtils.toString(stencilsetStream, "utf-8");
        } catch (Exception e) {
            throw new ActivitiException("Error while loading stencil set", e);
        }
    }
}
