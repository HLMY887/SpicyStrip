package xyz.hlmy.spicystrip.conf;

import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.ProcessEngineConfigurationConfigurer;
import org.springframework.stereotype.Component;

/**
 * 额外配置Activiti 设置数据源、事务管理器、全局事件监听器等配置信息
 */
@Component
public class ActivitiConfig implements ProcessEngineConfigurationConfigurer {

    /**
     * @param springProcessEngineConfiguration
     */
    @Override
    public void configure(SpringProcessEngineConfiguration springProcessEngineConfiguration) {
        springProcessEngineConfiguration.setActivityFontName("宋体");
        springProcessEngineConfiguration.setLabelFontName("宋体");
        springProcessEngineConfiguration.setAnnotationFontName("宋体");
    }
}
