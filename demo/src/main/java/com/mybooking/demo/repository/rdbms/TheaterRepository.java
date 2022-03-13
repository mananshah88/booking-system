package com.mybooking.demo.repository.rdbms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybooking.demo.model.rdbms.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

	public List<Theater> findByPartnerId(Integer partnerId);
}
