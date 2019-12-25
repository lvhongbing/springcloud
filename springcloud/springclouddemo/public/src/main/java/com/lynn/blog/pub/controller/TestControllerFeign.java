package com.lynn.blog.pub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lynn.blog.pub.TestServiceFeign;

@RequestMapping("feign")
@RestController
public class TestControllerFeign {

	@Autowired
	TestServiceFeign testServiceFeign;
	@RequestMapping("test")
	private String test() {
		return testServiceFeign.test();
	}
}
