package com.mybooking.demo.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybooking.demo.exceptions.InvalidScreenException;
import com.mybooking.demo.exceptions.InvalidTheaterException;
import com.mybooking.demo.model.rdbms.Screen;
import com.mybooking.demo.model.rdbms.Theater;
import com.mybooking.demo.repository.rdbms.TheaterRepository;
import com.mybooking.demo.service.TheaterService;

@Service
public class TheaterServiceImpl implements TheaterService {

	private TheaterRepository theaterRepo;

	@Autowired
	public TheaterServiceImpl(TheaterRepository theaterRepo) {
		this.theaterRepo = theaterRepo;
	}

	@Override
	public Screen validateAndGetTheater(Long theaterId, Long screenId) {

		/* Validate theaterId */
		Optional<Theater> requestedTheater = theaterRepo.findById(theaterId);
		if (requestedTheater.isEmpty()) {
			throw new InvalidTheaterException("Invalid theater");
		}
		var theater = requestedTheater.get();

		/* Validate screenId */
		return theater.getScreens().stream().filter(s -> s.getId().equals(screenId)).findAny()
				.orElseThrow(() -> new InvalidScreenException("Invalid Screen"));

	}

}
