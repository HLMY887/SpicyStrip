package xyz.hlmy.spicystrip.model.sys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.controller.BaseController;
import xyz.hlmy.spicystrip.model.sys.dto.DeptDto;
import xyz.hlmy.spicystrip.model.sys.service.SysDeptService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sys/dept")
public class DeptController extends BaseController {

    @Resource
    private SysDeptService sysDeptService;


    @GetMapping("/list")
    public R getDeptLists(@RequestBody DeptDto dto) {
        log.info("DeptController getDeptLists  START");
        R deptLists = sysDeptService.getDeptLists(dto);
        log.info("DeptController getDeptLists END");
        return deptLists;
    }
}
