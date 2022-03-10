package com.mybooking.demo.repository.rdbms;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybooking.demo.model.rdbms.BookingUnit;

@Repository
public interface BookingUnitRepository extends JpaRepository<BookingUnit, Long> {

	Optional<BookingUnit> findById(Long id);

}
