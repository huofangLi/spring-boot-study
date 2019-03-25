package com.springboot.mybatis;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication/*启动类*/
@MapperScan("com.springboot.mybatis.mapper")/*在启动之前扫描Mapper*/
@EnableSwagger2Doc
public class SpringBootMybatisApplication extends SpringBootServletInitializer {
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
//        return builder.sources(SpringBootMybatisApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(
                SpringBootMybatisApplication.class, args);
    }
}