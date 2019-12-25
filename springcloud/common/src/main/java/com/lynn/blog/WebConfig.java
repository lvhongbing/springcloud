package com.lynn.blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.lynn.blog.util.CustomRequestMappingHandlerMapping;
/**
 * yaml配置文件和代码同时设置了同样的属性，以代码设置的属性为准
 * @author Administrator
 *
 */

@SpringBootConfiguration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurationSupport 
//	implements 
//		WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> 
{

//	@Override
//	public void customize(ConfigurableServletWebServerFactory factory) {
//		factory.setPort(8888);
//	}
	/**
	 * 消息转换器
	 */
	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		super.configureMessageConverters(converters);
		
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastConfig = new FastJsonConfig();
		fastConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		List<MediaType> mediaTypeList = new ArrayList<>();
		mediaTypeList.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(mediaTypeList);
		
		fastConverter.setFastJsonConfig(fastConfig);
		converters.add(fastConverter);
	}
	@Override
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping handler = new CustomRequestMappingHandlerMapping();
		handler.setOrder(0);
		return handler;
	}
	
	@Bean
	@LoadBalanced //开启负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

