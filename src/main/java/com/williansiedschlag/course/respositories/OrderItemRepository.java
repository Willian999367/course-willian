package com.williansiedschlag.course.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.williansiedschlag.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
