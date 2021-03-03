package com.feather;

import java.util.Properties;

import com.feather.community.util.VideoAlarmLogion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动程序
 * 
 * @author feather
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableCaching(order = Ordered.HIGHEST_PRECEDENCE)
@EnableScheduling
public class FeatherApplication {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(FeatherApplication.class, args);

        Properties props = System.getProperties();
        props.put("ConfigurableApplicationContext@com.feather.FeatherApplication", ctx);

        VideoAlarmLogion.corn();
        System.out.println("\n启动成功\n\n");
    }
}