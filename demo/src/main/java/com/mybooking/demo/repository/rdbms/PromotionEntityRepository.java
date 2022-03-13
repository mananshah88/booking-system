package com.mybooking.demo.repository.rdbms;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybooking.demo.model.rdbms.PromotionEntity;

public interface PromotionEntityRepository extends JpaRepository<PromotionEntity, Long> {

}
