package com.mybooking.demo.repository.rdbms;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybooking.demo.model.rdbms.PromotionRestriction;

public interface PromotionRestrictionRepository extends JpaRepository<PromotionRestriction, Long> {

}
