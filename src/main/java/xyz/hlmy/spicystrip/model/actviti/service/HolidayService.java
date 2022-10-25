package xyz.hlmy.spicystrip.model.actviti.service;

import xyz.hlmy.spicystrip.common.R;

public interface HolidayService {
    R startProcess(String deployId);

    R completeTask(String taskId, String result);
}
