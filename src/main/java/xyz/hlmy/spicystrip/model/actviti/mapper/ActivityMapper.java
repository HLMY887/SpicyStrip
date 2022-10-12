package xyz.hlmy.spicystrip.model.actviti.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.hlmy.spicystrip.model.actviti.vo.ProcessModelVO;

/**
 * 工作流程操作
 */
public interface ActivityMapper {

    @Select("SELECT " +
            "rm.ID_ as id," +
            "rm.NAME_ as name," +
            "rm.KEY_ as `key`," +
            "rm.VERSION_ as version," +
            "rm.DEPLOYMENT_ID_ as deploymentId," +
            "rm.CREATE_TIME_ as createTime," +
            "rm.LAST_UPDATE_TIME_ as lastUpdateTime," +
            "rp.NAME_ as processName," +
            "rp.ID_ as processDefinitionId," +
            "IF(rp.SUSPENSION_STATE_=1, false, IF(rp.SUSPENSION_STATE_ is null, null, true)) as processSuspended " +
            "FROM " +
            "ACT_RE_MODEL rm " +
            "LEFT JOIN ACT_RE_PROCDEF rp ON rm.DEPLOYMENT_ID_ = rp.DEPLOYMENT_ID_ ${ew.customSqlSegment}")
    IPage<ProcessModelVO> listProcessModels(@Param(Constants.WRAPPER) Wrapper wrapper, IPage page);
}
