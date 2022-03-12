package com.mybooking.demo.service;

import com.mybooking.demo.model.rdbms.Screen;

public interface TheaterService {

	public Screen validateAndGetTheater(Long theaterId, Long screenId);

}
