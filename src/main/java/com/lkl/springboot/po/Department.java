package com.lkl.springboot.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

//import org.hibernate.annotations.Table;
import org.hibernate.validator.constraints.Length;






/**
* Title: Department
* Description: 部门  
*  columnDefinition移植性不好所以不推荐使用 各个数据库不一致
* @author HuangJian
* @date 2017年9月16日
*
*/
@Entity
@Table(name="t_department",catalog="imooc")
//@Table(appliesTo="t_department",comment="部门信息表",)
public class Department implements Serializable{

	/** 
	* @Fields serialVersionUID :
	*/ 
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="depa_id",length=8,columnDefinition="int(8) comment '部门ID 主键'")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer depaId;
	//部门名称
	@Column(name="depa_name",nullable=false,length=50,columnDefinition="varchar(50) comment '部门名称'")
	private String depaName;
	//部门编号
	@Column(name="depa_no",nullable=false,columnDefinition="int(8) comment '部门编号'")
	private Integer depaNo;
	
	@Column(name="depa_status",nullable=false,length=8,columnDefinition="int(8) comment '状态 0生效 1禁用'")
	private Integer status=0;
	
	@Column(name="is_del",nullable=true,columnDefinition="int(8) comment '是否删除' default 0")
	private Integer isDel;
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Department(Integer depaId, String depaName, Integer depaNo, Integer status) {
		super();
		this.depaId = depaId;
		this.depaName = depaName;
		this.depaNo = depaNo;
		this.status = status;
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
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Department [depaId=" + depaId + ", depaName=" + depaName + ", depaNo=" + depaNo + "]";
	}
	
	
}
