package com.mybooking.demo.repository.rdbms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybooking.demo.model.rdbms.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByType(Integer type);
}
