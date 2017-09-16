package com.lkl.springboot.service;

import java.util.List;

import com.lkl.springboot.po.Tuser;

public interface UserService {

	/**
	* Title: UserService.java
	* Description: 新增
	* @param user
	* @return
	* @author HuangJian
	* @date 2017年9月16日
	*/
	public Integer create(Tuser user);
	
	/**
	* Title: UserService.java
	* Description: 根据用户名删除
	* @param userName
	* @return
	* @author HuangJian
	* @date 2017年9月16日
	*/
	public Integer deleteByUserName(String userName);
	
	/**
	* Title: UserService.java
	* Description: 获得总量
	* @return
	* @author HuangJian
	* @date 2017年9月16日
	*/
	public Integer getAllCount();
	
	/**
	* Title: UserService.java
	* Description: 获取用户列表
	* @return
	* @author HuangJian
	* @date 2017年9月16日
	*/
	public List<Tuser> findUser();
	
	/**
	* Title: UserService.java
	* Description: 根据ID修改
	* @param user
	* @return
	* @author HuangJian
	* @date 2017年9月16日
	*/
	public Integer updateById(Tuser user);
}
