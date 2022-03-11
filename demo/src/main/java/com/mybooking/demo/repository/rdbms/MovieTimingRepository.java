package com.mybooking.demo.repository.rdbms;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybooking.demo.model.rdbms.MovieTiming;

@Repository
public interface MovieTimingRepository extends JpaRepository<MovieTiming, Long> {

	Optional<MovieTiming> findById(Long id);

}
