package com.cskaoyan.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

<<<<<<< HEAD

=======
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.cskaoyan.mall.mapper")
>>>>>>> bd10641386b7c775c6f09e84d082e63f9605ee82
public class MallApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

}
