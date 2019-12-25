package com.lynn.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloController {

	@RequestMapping("index")
	public String index() {
		return "这是一个eurekaclient";
	}
	
	@RequestMapping(value="hello")
	public Mono<String> hello(){
		return Mono.just("Hello *** world!");
	}	
}
