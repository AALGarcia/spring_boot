package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.T_program;

@Repository
public interface T_programService extends JpaRepository<T_program, Integer>{
	
}
