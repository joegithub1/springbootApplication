package com.lkl.springboot.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;






/**
* Title: Department
* Description: 部门
* @author HuangJian
* @date 2017年9月16日
*
*/
@Entity
@Table(name="t_department")
public class Department implements Serializable{

	/** 
	* @Fields serialVersionUID :
	*/ 
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="depa_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer depaId;
	//部门名称
	@Column(name="depa_name",nullable=false,length=25)
	private String depaName;
	//部门编号
	@Column(name="depa_no",nullable=false)
	private Integer depaNo;
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department(Integer depaId, String depaName, Integer depaNo) {
		super();
		this.depaId = depaId;
		this.depaName = depaName;
		this.depaNo = depaNo;
	}
	
	public Department(String depaName, Integer depaNo) {
		super();
		this.depaName = depaName;
		this.depaNo = depaNo;
	}

	public Integer getDepaId() {
		return depaId;
	}
	public void setDepaId(Integer depaId) {
		this.depaId = depaId;
	}
	public String getDepaName() {
		return depaName;
	}
	public void setDepaName(String depaName) {
		this.depaName = depaName;
	}
	public Integer getDepaNo() {
		return depaNo;
	}
	public void setDepaNo(Integer depaNo) {
		this.depaNo = depaNo;
	}

	@Override
	public String toString() {
		return "Department [depaId=" + depaId + ", depaName=" + depaName + ", depaNo=" + depaNo + "]";
	}
	
	
}
