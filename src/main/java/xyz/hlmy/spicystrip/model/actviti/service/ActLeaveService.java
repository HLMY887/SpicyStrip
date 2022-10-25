package xyz.hlmy.spicystrip.model.actviti.service;

import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.dto.LeveDto;
import xyz.hlmy.spicystrip.model.actviti.dto.TaskDto;
import xyz.hlmy.spicystrip.model.actviti.entity.ActLeave;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author lipenghui
 * @description 针对表【act_leave】的数据库操作Service
 * @createDate 2022-10-21 16:36:00
 */
public interface ActLeaveService extends IService<ActLeave> {


    R startLeveProcess(LeveDto dto);

    R completeTask(String taskId);

    R submitTask(TaskDto task);
}
