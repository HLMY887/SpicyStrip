package xyz.hlmy.spicystrip.util;

import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
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
import org.springframework.web.multipart.MultipartFile;
import xyz.hlmy.spicystrip.common.R;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

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
    public static R deployProcess(String filePath, String fileImage, String processName) {
        try {
            if (StrUtil.isEmpty(fileImage)) {
                Deployment deployment = activitiUtil.repositoryService.createDeployment().addClasspathResource(filePath).name(processName).deploy();
                log.info("流程ID-{}", deployment.getId());
                log.info("流程Name -{}", deployment.getName());
                log.info("流程KEY-{}", deployment.getKey());
                log.info("租户 ID -{}", deployment.getTenantId());
                log.info("类别 -{}", deployment.getCategory());
                log.info("部署时间 -{}", deployment.getDeploymentTime());
                return R.ok();
            } else {
                Deployment deployment = activitiUtil.repositoryService.createDeployment().addClasspathResource(filePath).addClasspathResource(fileImage).name(processName).deploy();
                log.info("流程ID{}", deployment.getId());
                log.info("流程Name{}", deployment.getName());
                log.info("流程KEY{}", deployment.getKey());
                log.info("租户 ID{}", deployment.getTenantId());
                log.info("类别{}", deployment.getCategory());
                log.info("部署时间{}", deployment.getDeploymentTime());
                return R.ok();
            }
        } catch (Exception e) {
            return R.err(400, "部署失败");
        }
    }

    /**
     * 部署流程方式之一(zip)
     *
     * @param file        文件
     * @param processName 流程名称
     * @return R
     */
    public static R deployProcess(MultipartFile file, String processName) {
        try {
            //拿到流
            InputStream inputStream = file.getInputStream();
            //拿到Zip流
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            Deployment deployment = activitiUtil.repositoryService.createDeployment().addZipInputStream(zipInputStream).name(processName).deploy();
            return R.ok();
        } catch (Exception e) {
            return R.err(400, "部署失败");
        }
    }
}
