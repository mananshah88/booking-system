package com.mybooking.demo.repository.rdbms;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybooking.demo.model.rdbms.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
