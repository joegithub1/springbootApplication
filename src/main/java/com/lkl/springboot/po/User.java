package com.lkl.springboot.po;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="user")
public class User {

	private @Value("${name:hj}") String name;
	private @Value("${age}") Integer age;
	private @Value("${remark}") String remark;
	private String address;
	private Address detailAddress;//详细地址
	private List<Address> allAddresss = new ArrayList<>();
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	
	

	

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", remark=" + remark + ", address=" + address
				+ ", detailAddress=" + detailAddress.toString() + ", allAddresss=" + allAddresss.toString() + "]";
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Address getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(Address detailAddress) {
		this.detailAddress = detailAddress;
	}

	public List<Address> getAllAddresss() {
		return allAddresss;
	}

	public void setAllAddresss(List<Address> allAddresss) {
		this.allAddresss = allAddresss;
	}
	
}
