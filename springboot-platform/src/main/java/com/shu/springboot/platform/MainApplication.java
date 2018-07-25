package com.shu.springboot.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shudongping
 * @date 2018/03/21
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.shu.springboot.platform.dao")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
