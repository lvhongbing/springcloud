package com.lynn.blog.config;

import org.springframework.cloud.config.server.EnableConfigServer;

import com.lynn.blog.Application;

@EnableConfigServer
public class ConfigApplication extends Application {

	public static void main(String[] args) {
		Application.startup(ConfigApplication.class, args);
	}
}
