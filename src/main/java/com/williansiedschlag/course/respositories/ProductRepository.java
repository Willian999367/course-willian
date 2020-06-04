package com.williansiedschlag.course.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.williansiedschlag.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
