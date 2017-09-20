package com.lkl.springboot.po;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Tuser implements RowMapper<Tuser>,Serializable{

	/** 
	* @Fields serialVersionUID :
	*/ 
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String userName;
	private String passWord;
	private String email;
	private String nickName;
	private String regTime;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	@Override
	public String toString() {
		return "Tuser [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", email=" + email
				+ ", nickName=" + nickName + ", regTime=" + regTime + "]";
	}
	@Override
	public Tuser mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tuser user = new Tuser();
		user.setUserId(rs.getInt("user_id"));
		user.setUserName(rs.getString("user_name"));
		user.setPassWord(rs.getString("pass_word"));
		user.setEmail(rs.getString("email"));
		user.setNickName(rs.getString("nick_name"));
		user.setRegTime(rs.getString("reg_time"));
		return user;
	}
	
}
