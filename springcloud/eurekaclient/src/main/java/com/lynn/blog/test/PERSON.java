package com.lynn.blog.test;

import io.searchbox.annotations.JestId;
import lombok.Data;

@Data
public class PERSON {

	@JestId
	private Long pk_id;
	private String name;
	private String age;
	private String address;
	
	public Long getPk_id() {
		return pk_id;
	}

	public void setPk_id(Long pk_id) {
		this.pk_id = pk_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PERSON getPerson() {
		return person;
	}

	public void setPerson(PERSON person) {
		this.person = person;
	}

	PERSON person = new PERSON();
}