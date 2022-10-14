package xyz.hlmy.spicystrip.model.actviti.service;

import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.entity.ActForm;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author lipenghui
 * @description 针对表【act_form(表单设计表)】的数据库操作Service
 * @createDate 2022-10-14 16:53:36
 */
public interface ActFormService extends IService<ActForm> {


    R saveForm(ActForm form);
}
