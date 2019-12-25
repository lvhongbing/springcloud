package com.lynn.blog.pub;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.lynn.blog.Application;

@MapperScan(basePackages = "com.lynn.blog.pub.mapper")
@EnableFeignClients(basePackages = "com.lynn.blog")
public class PublicApplication extends Application{

}
