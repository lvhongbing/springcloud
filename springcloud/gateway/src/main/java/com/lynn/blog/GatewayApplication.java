package com.lynn.blog;

import org.springframework.cloud.client.SpringCloudApplication;
import com.lynn.blog.Application;

/**
 * 
 * @author Administrator
 *
 */
@SpringCloudApplication
public class GatewayApplication extends Application{

	public static void main(String[] args) {
		Application.startup(GatewayApplication.class, args);
	}
}
