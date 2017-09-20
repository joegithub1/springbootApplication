package com.lkl.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lkl.springboot.po.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
