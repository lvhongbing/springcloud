package com.lynn.blog.pub;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="test")
public interface TestServiceFeign {

	@RequestMapping("/test")
	String test();
}
