package xyz.hlmy.spicystrip.model.actviti.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xyz.hlmy.spicystrip.model.actviti.entity.ActModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.hlmy.spicystrip.model.actviti.vo.ProcessModelVO;

/**
 * @author lipenghui
 * @description 针对表【ACT_MODEL(自定义模型表)】的数据库操作Mapper
 * @createDate 2022-10-20 14:14:34
 * @Entity xyz.hlmy.spicystrip.model.entity.ActModel
 */
public interface ActModelMapper extends BaseMapper<ActModel> {

    @Select("SELECT " +
            "rm.ID_ as id," +
            "rm.NAME_ as name," +
            "rm.KEY_ as `key`," +
            "rm.VERSION_ as version,"
            + "rm.DEPLOYMENT_ID_ as deploymentId,"
            + "rm.CREATE_TIME_ as createTime,"
            + "rm.LAST_UPDATE_TIME_ as lastUpdateTime,"
            + "rp.NAME_ as processName,"
            + "rp.ID_ as processDefinitionId,"
            + "IF(rp.SUSPENSION_STATE_=1, false, IF(rp.SUSPENSION_STATE_ is null, null, true)) as processSuspended, "
            + "pro.diagram_name AS diagramName "
            + "FROM " + "ACT_RE_MODEL rm "
            + "LEFT JOIN ACT_RE_PROCDEF rp ON rm.DEPLOYMENT_ID_ = rp.DEPLOYMENT_ID_ LEFT JOIN" +
            " act_process pro  ON" +
            " rm.DEPLOYMENT_ID_ = pro.id  "
            + "${ew.customSqlSegment}")
    IPage<ProcessModelVO> listProcessModels(@Param(Constants.WRAPPER) Wrapper wrapper, IPage page);


    @Update("update ACT_RE_PROCDEF set NAME_=#{name} where ID_=#{processDefinitionId}")
    void updateProcessDefinitionName(@Param("name") String name, @Param("processDefinitionId") String processDefinitionId);
}




