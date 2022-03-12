package com.mybooking.demo.serviceimpl;

import java.util.Date;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.exceptions.InvalidRequestSeatException;
import com.mybooking.demo.exceptions.InvalidTimeslotException;
import com.mybooking.demo.model.rdbms.MovieTimeslot;
import com.mybooking.demo.model.rdbms.Screen;
import com.mybooking.demo.model.rdbms.SeatDetails;
import com.mybooking.demo.service.MovieTimeslotService;

@Service
public class MovieTimeslotServiceImpl extends BaseServiceImpl implements MovieTimeslotService {

	@Override
	public MovieTimeslot validateAndGetMovieTimeslot(Screen screen, Date bookingDateTimeSlot) {
		/* validate movie time slot (2022-01-01 12:30:00) */
		Predicate<MovieTimeslot> timeSlotFilter = timeslot -> !timeslot.getTimeslot().equals(bookingDateTimeSlot);
		return screen.getMovietimeslots().stream().filter(timeSlotFilter).findAny()
				.orElseThrow(() -> new InvalidTimeslotException("Invalid Timeslot"));
	}

	@Override
	public boolean validSeatsOrNot(MovieTimeslot movieTimeSlot, Set<Long> seatIds) {
		Set totalSeats = movieTimeSlot.getSeatDetails().stream().map(SeatDetails::getId).collect(Collectors.toSet());
		if (!totalSeats.containsAll(seatIds)) {
			throw new InvalidRequestSeatException("Invalid Requested Seat");
		}
		return true;
	}

}
