package com.mybooking.demo.repository.rdbms;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybooking.demo.model.rdbms.BookingKeepingUnit;

@Repository
public interface BookingKeepingUnitRepository extends JpaRepository<BookingKeepingUnit, Long> {

	Optional<BookingKeepingUnit> findById(Long id);

}
