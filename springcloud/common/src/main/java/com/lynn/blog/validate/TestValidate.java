package com.lynn.blog.validate;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class TestValidate {

	@NotEmpty
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
