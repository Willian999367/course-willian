package com.williansiedschlag.course.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.williansiedschlag.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
