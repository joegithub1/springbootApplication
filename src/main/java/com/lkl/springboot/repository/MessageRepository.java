package com.lkl.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lkl.springboot.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
