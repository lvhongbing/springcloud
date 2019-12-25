package com.lynn.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Administrator
 *
 */
@SpringCloudApplication
@ComponentScan(basePackages="com.lynn.blog")
public abstract class Application{
	public static void startup(Class<?> cla,String[] args) {
		SpringApplication.run(cla, args);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
