package com.mybooking.demo.repository.rdbms;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybooking.demo.model.rdbms.SeatDetails;

public interface SeatDetailsRepo extends JpaRepository<SeatDetails, Long> {

}
