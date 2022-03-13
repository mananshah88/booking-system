package com.mybooking.demo.repository.rdbms;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybooking.demo.model.rdbms.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

	public Optional<Promotion> findByPromotionCode(String promotionCode);

	public List<Promotion> findByType(String type);
}
