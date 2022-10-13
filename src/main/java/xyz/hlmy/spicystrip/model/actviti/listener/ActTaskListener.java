package xyz.hlmy.spicystrip.model.actviti.listener;

import lombok.extern.slf4j.Slf4j;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * 会签监听
 */
@Slf4j
public class ActTaskListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        log.info(delegateTask.toString());
        String taskId = delegateTask.getExecutionId();

    }
}
