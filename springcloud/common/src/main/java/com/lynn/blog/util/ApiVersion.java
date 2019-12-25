package com.lynn.blog.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.Mapping;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Mapping
@Documented
public @interface ApiVersion {
	int value();
}
