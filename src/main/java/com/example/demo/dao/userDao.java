package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Register;

public interface userDao extends JpaRepository<Register, Integer> {

}
