package com.lynn.blog.control;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lynn.blog.result.SingleResult;
import com.lynn.blog.util.ApiVersion;
import com.lynn.blog.validate.TestValidate;

@RequestMapping("{version}")
@RestController
@ApiVersion(1)
public class TestV1Controller {

	@Autowired
	private SingleResult singleResult;
	@GetMapping(value = "index",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String index(@Valid TestValidate validat,BindingResult result) {
		validate(result);
		return "请求成功,hello "+validat.getName();
	}
	
	protected void validate(BindingResult result) {
		if(result.hasFieldErrors()) {
			List<FieldError> errorList = result.getFieldErrors();
			errorList.stream().forEach(item->Assert.isTrue(false,item.getDefaultMessage()));
		}
	}
	@ExceptionHandler
	public SingleResult doError(Exception exception) {
		if(StringUtils.isBlank(exception.getMessage())) {
			return singleResult.buildFailure();
		}
		return singleResult.buildFailure(exception.getMessage());
	}
}
