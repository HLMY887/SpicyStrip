package xyz.hlmy.spicystrip.model.actviti.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.controller.BaseController;
import xyz.hlmy.spicystrip.model.actviti.dto.ModelDTO;
import xyz.hlmy.spicystrip.model.actviti.dto.MyTodoDTO;
import xyz.hlmy.spicystrip.model.actviti.dto.ProcessQuery;
import xyz.hlmy.spicystrip.model.actviti.service.ActModelService;
import xyz.hlmy.spicystrip.model.actviti.vo.MyProListVO;
import xyz.hlmy.spicystrip.model.actviti.vo.ProcessModelVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


/**
 * 模型控制层
 */
@RestController
@RequestMapping(value = "/model")
public class ActModelController extends BaseController {

    @Resource
    private ActModelService actModelService;

    /**
     * 添加模型
     *
     * @param actModel 模型参数
     * @return R
     */
    @PostMapping("/add")
    public R insertPro(@RequestBody ModelDTO actModel) {
        log.info("ActModelController insertPro START");
        R r = actModelService.insertPro(actModel);
        log.info("ActModelController insertPro END");
        return r;
    }

    /**
     * 更新模型
     *
     * @param modelId     ID
     * @param name        名称
     * @param description 描述
     * @param json_xml    xml
     * @param svg_xml     xml
     * @return R
     */
    @PutMapping("{modelId}/save")
    public R saveModel(@PathVariable String modelId, @RequestParam String name, @RequestParam String description, @RequestParam String json_xml, @RequestParam String svg_xml) {
        log.info("ActModelController saveModel START");
        R r = actModelService.saveModel(modelId, name, description, json_xml, svg_xml);
        log.info("ActModelController saveModel END");
        return r;
    }

    /**
     * 获取模型列表
     *
     * @return R
     */
    @GetMapping("/list")
    public IPage<ProcessModelVO> getModelList() {
        log.info("ActModelController getModelList START");
        IPage<ProcessModelVO> modelList = actModelService.getModelList();
        log.info("ActModelController getModelList END");
        return modelList;
    }

    /**
     * 获取模型数据
     *
     * @param modelId 模型ID
     * @return ObjectNode
     */
    @GetMapping("/{modelId}/json")
    public ObjectNode getModelJson(@PathVariable String modelId) {
        log.info("ActModelController getModelJson START");
        ObjectNode modelJson = actModelService.getModelJson(modelId);
        log.info("ActModelController getModelJson END");
        return modelJson;
    }

    /**
     * 部署/发布模型
     *
     * @param id 模型ID
     * @return R
     */
    @PostMapping("/deploy/{id}")
    public R deployModel(@PathVariable String id) {
        log.info("ActModelController getModel START");
        R r = actModelService.deployModel(id);
        log.info("ActModelController getModel END");
        return r;
    }

    @GetMapping("/img/{modeId}")
    public R getImage(@PathVariable String modeId) {
        return R.ok();
    }

    /**
     * 删除整个流程的所有数据
     *
     * @param modelId 模型ID
     * @return R
     */
    @GetMapping("/del/{modelId}")
    public R deleteProcess(@PathVariable String modelId) {
        log.info("ActModelController getModel START");
        R r = actModelService.deleteProcess(modelId);
        log.info("ActModelController getModel END");
        return r;
    }

    /**
     * 可用流程列表
     *
     * @return Page
     */
    @GetMapping("/dep/list")
    public IPage<ProcessModelVO> getDeploymentProcess() {
        log.info("ActModelController getDeploymentProcess START");
        IPage<ProcessModelVO> process = actModelService.getDeploymentProcess();
        log.info("ActModelController getDeploymentProcess END");
        return process;
    }

    /**
     * 启动流程
     *
     * @param modelId 模型ID
     * @return R
     */
    @GetMapping("/pro/{modelId}")
    public R startProcess(@PathVariable String modelId) {
        log.info("ActModelController startProcess START");
        R r = actModelService.startProcess(modelId);
        log.info("ActModelController startProcess END");
        return r;
    }

    /**
     * 我的申请(历史)
     *
     * @param userName 用户名称
     * @param proName  流程名称
     * @return List
     */
    //TODO  用户名称有RBAC可以获取(现在方式用于测试)
    @PostMapping("/my/pro/list")
    public ProcessQuery<MyProListVO> myProcessList(@RequestParam("userName") String userName, @RequestParam("proName") String proName) {
        log.info("ActModelController myProcessList START");
        log.info(userName + "-----" + proName);
        ProcessQuery<MyProListVO> query = actModelService.myProcessList(userName, proName);
        log.info("ActModelController myProcessList END");
        return query;
    }

    /**
     * 我的待办
     *
     * @param dto 返回参数
     * @return R
     */
    @PostMapping("/my/todo/list")
    public R getMyTodoList(@RequestBody MyTodoDTO dto) {
        log.info("ActModelController myTodoList START");
        R myTodoList = actModelService.getMyTodoList(dto);
        log.info("ActModelController myTodoList END");
        return myTodoList;
    }

    /**
     * 查看部署流程图
     *
     * @param dpyId 流程部署ID
     * @return ResponseEntity
     */
    @GetMapping("/my/{dpyId}/img")
    public ResponseEntity<Object> viewProImage(@PathVariable String dpyId) {
        ResponseEntity<Object> entity = actModelService.viewProImage(dpyId);
        return entity;
    }

    /**
     * 执行流程图
     *
     * @param processInstanceId 流程实例ID
     * @param response          流
     */
    @GetMapping(value = "process/{processInstanceId}/image.png")
    public void processFlowChartImage(@PathVariable("processInstanceId") String processInstanceId, HttpServletResponse response) {
        actModelService.processFlowChartImage(processInstanceId, response);
    }

}
