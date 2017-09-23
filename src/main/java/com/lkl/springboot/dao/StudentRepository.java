package com.lkl.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lkl.springboot.po.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
