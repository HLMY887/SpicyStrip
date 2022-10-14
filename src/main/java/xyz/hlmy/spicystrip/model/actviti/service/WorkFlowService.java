package xyz.hlmy.spicystrip.model.actviti.service;


import org.springframework.web.bind.annotation.RequestParam;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.dto.DelProcessModelDto;
import xyz.hlmy.spicystrip.model.actviti.dto.ModelDto;
import xyz.hlmy.spicystrip.model.actviti.dto.ProcessQueryDTo;
import xyz.hlmy.spicystrip.model.actviti.dto.SaveProcessDto;


import java.io.InputStream;


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

    void importProcessModel(InputStream file);

    R RejectTask(String taskId);


    R getProcessesList();

    R deploy(String modelId);

    R deployTest(InputStream file, String name);

    R start(@RequestParam("deployKey") String deployKey);

    R saveProcess(SaveProcessDto dto);
}
