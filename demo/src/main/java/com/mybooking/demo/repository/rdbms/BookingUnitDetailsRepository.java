package com.mybooking.demo.repository.rdbms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybooking.demo.model.rdbms.BookingUnitDetails;

@Repository
public interface BookingUnitDetailsRepository extends JpaRepository<BookingUnitDetails, Long> {

}