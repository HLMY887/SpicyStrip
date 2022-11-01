package xyz.hlmy.spicystrip.model.actviti.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.controller.BaseController;
import xyz.hlmy.spicystrip.model.actviti.dto.MyTodoDTO;
import xyz.hlmy.spicystrip.model.actviti.service.ActModelService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/my/todo")
public class MyToDoController extends BaseController {
    @Resource
    private ActModelService actModelService;

    /**
     * 我的待办
     *
     * @param dto 返回参数
     * @return R
     */
    @PostMapping("/list")
    public R getMyTodoList(@RequestBody MyTodoDTO dto) {
        log.info("ActModelController myTodoList START");

        R myTodoList = actModelService.getMyTodoList(dto);
        log.info("ActModelController myTodoList END");
        return myTodoList;
    }
}
