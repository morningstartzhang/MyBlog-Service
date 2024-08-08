package com.lovesh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zdm
 * @date 2023/09/08
 */
@SpringBootApplication
@MapperScan({"com.lovesh.dao"})
@PropertySource(value = "classpath:/config/mode.properties")
public class MyblogUcWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyblogUcWebApplication.class, args);
    }

}
