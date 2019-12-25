package com.lynn.blog.util;

import java.lang.reflect.Method;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class CustomRequestMappingHandlerMapping extends
		RequestMappingHandlerMapping{

	@Override
	protected RequestCondition<ApiVersionCondition> getCustomTypeCondition(Class<?> handlerType) {
		// TODO Auto-generated method stub
		ApiVersion apiVersion = AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
		return createCondition(apiVersion);
	}

	@Override
	protected RequestCondition<ApiVersionCondition> getCustomMethodCondition(Method method) {
		// TODO Auto-generated method stub
		ApiVersion apiVersion = AnnotationUtils.findAnnotation(method, ApiVersion.class);
		return createCondition(apiVersion);
	}

	private RequestCondition<ApiVersionCondition> createCondition(ApiVersion apiVersion){
		return apiVersion ==null?null:new ApiVersionCondition(apiVersion.value());
	}
}
