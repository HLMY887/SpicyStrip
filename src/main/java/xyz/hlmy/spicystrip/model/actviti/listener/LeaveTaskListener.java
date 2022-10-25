package xyz.hlmy.spicystrip.model.actviti.listener;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;
import xyz.hlmy.spicystrip.controller.BaseController;

/**
 * 请假监听
 */
public class LeaveTaskListener extends BaseController implements TaskListener, ExecutionListener {


    /**
     * 任务监听器
     *
     * @param delegateTask
     */
    @Override
    public void notify(DelegateTask delegateTask) {
        log.info(delegateTask.toString());
        String eventName = delegateTask.getEventName();
        if (eventName.equals("create")) {
            delegateTask.setAssignee("王五");
        }
        //获取流程节点
        String exId = delegateTask.getExecutionId();
        log.info("当前流程节点{}", exId.toString());
    }


    /**
     * 执行监听器
     *
     * @param delegateExecution
     * @throws Exception
     */
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        log.info(delegateExecution.toString());
        String notifyName = delegateExecution.getEventName();
        switch (notifyName) {
            case "start":
                log.info("eventName = {} 启动了", notifyName);
                break;
            case "end":
                log.info("eventName = {} 结束了", notifyName);
                break;
            case "take":
                log.info("eventName = {} 接收了", notifyName);
                break;
            default:
                log.info("eventName = {} 默认执行了", notifyName);
        }
    }
}
