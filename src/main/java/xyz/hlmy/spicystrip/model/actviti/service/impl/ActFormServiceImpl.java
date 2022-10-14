package xyz.hlmy.spicystrip.model.actviti.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.hlmy.spicystrip.common.R;
import xyz.hlmy.spicystrip.model.actviti.entity.ActForm;
import xyz.hlmy.spicystrip.model.actviti.service.ActFormService;
import xyz.hlmy.spicystrip.model.actviti.mapper.ActFormMapper;
import org.springframework.stereotype.Service;

/**
 * @author lipenghui
 * @description 针对表【act_form(表单设计表)】的数据库操作Service实现
 * @createDate 2022-10-14 16:53:36
 */
@Service
public class ActFormServiceImpl extends ServiceImpl<ActFormMapper, ActForm> implements ActFormService {

    /**
     * @param form
     * @return
     */
    @Override
    public R saveForm(ActForm form) {
        boolean save = super.save(form);
        if (save) {
            return R.ok();
        }
        return R.err(400, "创建表单失败");
    }
}




