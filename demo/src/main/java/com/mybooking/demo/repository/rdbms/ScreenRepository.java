package com.mybooking.demo.repository.rdbms;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybooking.demo.model.rdbms.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Long> {

}
