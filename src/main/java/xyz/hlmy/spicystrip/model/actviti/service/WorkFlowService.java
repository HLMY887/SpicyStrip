package xyz.hlmy.spicystrip.model.actviti.service;


import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.dto.DelProcessModelDto;
import xyz.hlmy.spicystrip.model.actviti.dto.ModelDto;
import xyz.hlmy.spicystrip.model.actviti.dto.ProcessQueryDTo;


/**
 * 工作流程业务层
 */
public interface WorkFlowService {
    /**
     * 检索流程列表
     *
     * @param dto 参数
     * @return IPage
     */
    R getProcesses(ProcessQueryDTo dto);


    R saveProcessModel(ModelDto dto);

    R batchDeleteProcessModels(DelProcessModelDto dto);

    R getMyProcessList(ProcessQueryDTo dto);
}
