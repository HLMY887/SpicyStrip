package xyz.hlmy.spicystrip;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {org.activiti.spring.boot.SecurityAutoConfiguration.class, SecurityAutoConfiguration.class})
@MapperScan("xyz.hlmy.spicystrip.model.*.mapper")
public class SpicyStripApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpicyStripApplication.class, args);
    }
}
