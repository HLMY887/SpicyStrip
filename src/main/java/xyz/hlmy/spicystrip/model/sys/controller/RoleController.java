package xyz.hlmy.spicystrip.model.sys.controller;

import org.springframework.web.bind.annotation.*;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.controller.BaseController;
import xyz.hlmy.spicystrip.model.sys.dto.RoleDto;
import xyz.hlmy.spicystrip.model.sys.service.SysRoleService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sys/role")
public class RoleController extends BaseController {

    @Resource
    private SysRoleService roleService;

    /**
     * 角色列表
     *
     * @param dto 参数
     * @return R
     */
    @GetMapping("/list")
    public R getRolesLists(@RequestBody RoleDto dto) {
        log.info("RoleController getRolesLists   START ");
        R rolesLists = this.roleService.getRolesLists(dto);
        log.info("RoleController getRolesLists END ");
        return rolesLists;
    }

    /**
     * 添加角色/分类
     *
     * @param dto 参数
     * @return R
     */
    @PostMapping("/save")
    public R saveRole(@RequestBody RoleDto dto) {
        log.info("RoleController saveRole  START");
        R r = this.roleService.saveRole(dto);
        log.info("RoleController saveRole END");
        return r;
    }
}
