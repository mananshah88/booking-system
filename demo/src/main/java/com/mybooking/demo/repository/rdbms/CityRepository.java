package com.mybooking.demo.repository.rdbms;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybooking.demo.model.rdbms.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
