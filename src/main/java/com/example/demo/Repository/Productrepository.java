package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Products;

@Repository
public interface Productrepository extends JpaRepository<Products, String> {

	Optional<Products> findById(String id);

}
