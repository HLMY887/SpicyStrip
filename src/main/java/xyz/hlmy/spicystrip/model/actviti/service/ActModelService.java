package xyz.hlmy.spicystrip.model.actviti.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.engine.history.HistoricProcessInstance;
import org.springframework.http.ResponseEntity;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.dto.ModelDTO;


import xyz.hlmy.spicystrip.model.actviti.dto.MyTodoDTO;
import xyz.hlmy.spicystrip.model.actviti.dto.ProcessQuery;
import xyz.hlmy.spicystrip.model.actviti.entity.ActModel;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.hlmy.spicystrip.model.actviti.vo.MyProListVO;

import xyz.hlmy.spicystrip.model.actviti.vo.ProcessModelVO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author lipenghui
 * @description 针对表【ACT_MODEL(自定义模型表)】的数据库操作Service
 * @createDate 2022-10-20 14:14:34
 */
public interface ActModelService extends IService<ActModel> {


    R insertPro(ModelDTO actModel);

    R saveModel(String modelId, String name, String description, String json_xml, String svg_xml);

    IPage<ProcessModelVO> getModelList();

    ObjectNode getModelJson(String modelId);

    R deployModel(String modelId);


    R deleteProcess(String modelId);

    IPage<ProcessModelVO> getDeploymentProcess();

    R startProcess(String modelId);

    ProcessQuery<MyProListVO> myProcessList(String userName, String proName);

    R getMyTodoList(MyTodoDTO dto);

    HistoricProcessInstance getHistoricProcessInstanceByProcessInstanceId(String processInstanceId);

    ResponseEntity<Object> viewProImage(String dpyId);

    void processFlowChartImage(String processInstanceId, HttpServletResponse response);

    R suspendProcessDefinitionByIds(List<String> deploymentIds);

    R activationProcess(List<String> deploymentIds);
}
