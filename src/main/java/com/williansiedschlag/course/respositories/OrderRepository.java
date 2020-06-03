package com.williansiedschlag.course.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.williansiedschlag.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
