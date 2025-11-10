package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Apprentice;

@Repository
public interface apprenticeService extends JpaRepository<Apprentice, Integer> {

}
