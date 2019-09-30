package com.cskaoyan.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
<<<<<<< HEAD
@MapperScan("com.cskaoyan.mall.mapper")
=======
@EnableTransactionManagement
@MapperScan(basePackages = "com.cskaoyan.mall")
>>>>>>> 99812116175aec6cc1a7392a2d1d155d24a277ed
public class MallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

}
