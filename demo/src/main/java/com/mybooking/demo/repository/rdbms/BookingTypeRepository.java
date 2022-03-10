package com.mybooking.demo.repository.rdbms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybooking.demo.model.rdbms.BookingType;

@Repository
public interface BookingTypeRepository extends JpaRepository<BookingType, Long> {

}
