package com.williansiedschlag.course.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.williansiedschlag.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
