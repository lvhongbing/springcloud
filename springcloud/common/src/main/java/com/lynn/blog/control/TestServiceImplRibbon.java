package com.lynn.blog.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class TestServiceImplRibbon implements TestServiceRibbon{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public String test() {
		return restTemplate.postForEntity("http://TEST/test", null, String.class).getBody();
	}

}
