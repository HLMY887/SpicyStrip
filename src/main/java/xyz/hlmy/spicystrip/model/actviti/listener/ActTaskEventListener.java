package xyz.hlmy.spicystrip.model.actviti.listener;

import lombok.extern.slf4j.Slf4j;
import org.activiti.api.task.runtime.events.TaskAssignedEvent;
import org.activiti.api.task.runtime.events.TaskCompletedEvent;
import org.activiti.api.task.runtime.events.listener.TaskRuntimeEventListener;
import org.springframework.context.annotation.Bean;

/**
 * 任务事件监听
 */
@Slf4j
public class ActTaskEventListener {

    /**
     * 任务认领 监听
     *
     * @return taskAssigned
     */
    @Bean
    public TaskRuntimeEventListener<TaskAssignedEvent> taskAssignedListener() {
        return taskAssigned -> log.info(">>> 任务: '{}' 被认领了, 认领者是: '{}'", taskAssigned.getEntity().getName(), taskAssigned.getEntity().getAssignee());
    }


    /**
     * 任务处理 监听
     *
     * @return taskCompleted
     */
    @Bean
    public TaskRuntimeEventListener<TaskCompletedEvent> taskCompletedListener() {
        return taskCompleted -> log.info(">>> 任务: '{}' 被处理了, 处理者是: '{}'", taskCompleted.getEntity().getName(), taskCompleted.getEntity().getOwner());
    }
}
