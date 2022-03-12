package com.mybooking.demo.service;

import java.util.Date;
import java.util.Set;

import com.mybooking.demo.model.rdbms.MovieTimeslot;
import com.mybooking.demo.model.rdbms.Screen;

public interface MovieTimeslotService {

	public MovieTimeslot validateAndGetMovieTimeslot(Screen screen, Date bookingDateTimeSlot);

	public boolean validSeatsOrNot(MovieTimeslot movieTimeSlot, Set<Long> seatIds);

}
