package com.cskaoyan.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
<<<<<<< HEAD
@MapperScan("com.cskaoyan.mall.mapper")
@EnableTransactionManagement
=======
@EnableTransactionManagement
@MapperScan(basePackages = "com.cskaoyan.mall.mapper")
>>>>>>> 5b2e04ed061f3ebc71b64876eb23f150042c414c
public class MallApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

}
