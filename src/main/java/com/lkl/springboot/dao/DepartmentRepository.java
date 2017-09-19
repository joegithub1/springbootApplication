package com.lkl.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lkl.springboot.po.Department;

/**
* Title: DepartmentRepository
* Description: 
* 可以看到该接口本身已经实现了创建（save）、更新（save）、删除（delete）、查询（findAll、findOne）等基本操作的函数，因此对于这些基础操作的数据访问就不需要开发者再自己定义。
* @author HuangJian
* @date 2017年9月16日
*
*/
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Department findByDepaName(String depaName);
	
	Department findByDepaNameAndDepaNo(String depaName,Integer depaNo);
	
	Department getByDepaId(Integer depaId);
	
	//List<Department> findOrderByDepaId();
	/**
	* Title: DepartmentRepository.java
	* Description: 修改信息
	* @param depaName 部门名称
	* @param depaNo 部门号
	* @param depaId 部门id
	* @return
	* @author HuangJian
	* @date 2017年9月16日
	*/
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value="update t_department d set d.depa_name=?,d.depa_no=? where d.depa_id=?",nativeQuery=true)
	int updateByDepaId(String depaName,Integer depaNo,Integer depaId);
	
	
	/*@Query(value = "select * from t_department d where d.depa_name=:depaName",nativeQuery=true)
	Department findDepa(@Param("depaName") String depaName);
	*/
	
}
