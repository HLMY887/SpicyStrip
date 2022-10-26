package xyz.hlmy.spicystrip.model.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.hlmy.spicystrip.model.sys.entity.SysLogin;
import xyz.hlmy.spicystrip.model.sys.service.SysLoginService;
import xyz.hlmy.spicystrip.model.sys.mapper.SysLoginMapper;
import org.springframework.stereotype.Service;

/**
* @author lipenghui
* @description 针对表【sys_login(用户登录日志)】的数据库操作Service实现
* @createDate 2022-10-26 17:59:22
*/
@Service
public class SysLoginServiceImpl extends ServiceImpl<SysLoginMapper, SysLogin>
    implements SysLoginService{

}




