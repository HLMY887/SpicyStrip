package xyz.hlmy.spicystrip.util;

import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Activiti工具类
 */
@Component
public class ActivitiUtil {
    private static Logger log = LoggerFactory.getLogger(ActivitiUtil.class);
    /**
     * 流程定义相关操作
     */
    @Autowired
    private ProcessRuntime processRuntime;

    /**
     * 任务相关操作
     */
    @Autowired
    private TaskRuntime taskRuntime;

    /**
     * 流程部署操作
     */
    @Autowired
    private RepositoryService repositoryService;

    /**
     * 对用户任务（UserTask）管理和控制操作
     */
    @Autowired
    private TaskService taskService;

    /**
     * 流程历史操作
     */
    @Autowired
    private HistoryService historyService;

    /**
     * 流程引擎中的流程运行控制服务
     */
    @Autowired
    private RuntimeService runtimeService;

    private static ActivitiUtil activitiUtil;

    @PostConstruct
    public void init() {
        // processRuntime等为static时无法注入，必须用activitiUtil.processRuntime形式
        activitiUtil = this;
    }

    /**
     * 部署流程方式之一(BPMN)
     *
     * @param filePath    BPMN存放的路径
     * @param fileImage   BPMN存放图片的路径
     * @param processName 流程名称
     */
    public static void deployProcess(String filePath, String fileImage, String processName) {
        Deployment deployment = activitiUtil.repositoryService.createDeployment()
                .addClasspathResource(filePath)
                .addClasspathResource(fileImage)
                .name(processName)
                .deploy();
        System.out.println("流程部署成功！ " + "部署id:"
                + deployment.getId() + "  " + "部署名称:" + deployment.getName());
    }
}
