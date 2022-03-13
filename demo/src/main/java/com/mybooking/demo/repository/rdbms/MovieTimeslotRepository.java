package com.mybooking.demo.repository.rdbms;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybooking.demo.model.rdbms.MovieTimeslot;

public interface MovieTimeslotRepository extends JpaRepository<MovieTimeslot, Long> {

	Optional<MovieTimeslot> findById(Long id);

}
