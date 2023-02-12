package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Register;

public interface UserRepository extends JpaRepository<Register,Long> {

}
