package com.mybooking.demo.repository.rdbms;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybooking.demo.model.rdbms.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
