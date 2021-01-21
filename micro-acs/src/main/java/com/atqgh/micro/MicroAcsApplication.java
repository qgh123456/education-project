package com.atqgh.micro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ProjectName: education-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/9/12 20:19
 */
@SpringBootApplication
@EnableSwagger2
//@EnableDiscoveryClient
//@EnableFeignClients
@MapperScan(basePackages = {"com.atqgh.micro.**.mapper"})
public class MicroAcsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroAcsApplication.class, args);
    }
}
