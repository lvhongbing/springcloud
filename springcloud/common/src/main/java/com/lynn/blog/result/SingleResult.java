package com.lynn.blog.result;

import org.junit.runner.Result;
import org.springframework.stereotype.Component;
@Component
public class SingleResult extends Result{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code="0";
	private String message = "空";
	private String data =null;
	
	public SingleResult() {
		super();
	}
	public SingleResult buildFailure() {
		return new SingleResult();
	}
	public SingleResult buildFailure(String message) {
		this.message = message;
		return new SingleResult();
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
