package com.mybooking.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mybooking.demo.dto.upload.PriceQunatityDetail;
import com.mybooking.demo.dto.upload.ScheduleDto;
import com.mybooking.demo.dto.upload.UploadRequestDTO;
import com.mybooking.demo.model.rdbms.BookingType;
import com.mybooking.demo.model.rdbms.MovieTiming;
import com.mybooking.demo.model.rdbms.MoviePricing;
import com.mybooking.demo.model.rdbms.Screen;
import com.mybooking.demo.repository.rdbms.BookingTypeRepository;
import com.mybooking.demo.repository.rdbms.ScreenRepository;
import com.mybooking.demo.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {

	private ScreenRepository screenRepository;
	private BookingTypeRepository bookingTypeRepository;

	@Autowired
	public UploadServiceImpl(ScreenRepository screenRepository, BookingTypeRepository bookingTypeRepository) {
		this.screenRepository = screenRepository;
		this.bookingTypeRepository = bookingTypeRepository;
	}

	/*
	 * Assumption: Token is valid Authorization is done
	 * 
	 * @Valid annotation to requested DTO and it also has all the validations by
	 * annotated
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 2, readOnly = false, rollbackFor = Exception.class)
	@Override
	public Boolean uploadDetails(UploadRequestDTO uploadRequestDTO) {

		/*
		 * if(!isValidTheater(uploadRequestDTO.getTheaterId())) { 
		 * 	throw new InvalidTheaterException("InValid Theater"); 
		 * }
		 * if(!areValidScreens(uploadRequestDTO.getTheaterId().getScreens())) { 
		 * 	throw new InvalidScreenException("InValid Screen"); 
		 * }
		 */
		
		uploadRequestDTO.getScreens().forEach(screenDto -> {
			var screen = screenRepository.findById(screenDto.getScreenId()).get();
			screenDto.getSchedule().forEach(schedule -> screen.addMovieTiming(getNewMovieTiming(schedule)));
			screenRepository.save(screen);
		});

		return true;
	}

	// MANAN
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 2, readOnly = false, rollbackFor = Exception.class)
	@Override
	public Boolean modifyDetails(UploadRequestDTO uploadRequestDTO) {
		uploadRequestDTO.getScreens().forEach(screenDto -> {
			var screen = screenRepository.findById(screenDto.getScreenId()).get();
			screenDto.getSchedule().forEach(schedule -> modifyMovietiming(screen, schedule));
			screenRepository.save(screen);
		});
		return true;
	}

	public boolean isValidTheater(Integer theaterId) {
		// check DB has that valued and it is own by the same Partner(Loggedin User)
		return true;
	}

	public boolean areValidScreens(List<Integer> screenIds) {
		// check DB has that value and it is own by the same Partner(Loggedin User)
		return true;
	}

	public boolean areValidScheduledStartTime() {
		return true;
	}

	public boolean areValidMovies() {
		return true;
	}

	public boolean areValidPriceQuantityDetails() {
		return true;
	}

	public MovieTiming getNewMovieTiming(ScheduleDto schedule) {
		var movietiming = new MovieTiming(schedule.getMovieId(), schedule.getStartTime());
		schedule.getPriceQunatityDetail().forEach(detail -> movietiming.addMoviePricingDetails(
				getNewMoviePricing(detail.getBookingTypeId(), detail.getPrice(), detail.getSeats())));
		return movietiming;
	}

	public MoviePricing getNewMoviePricing(Long bookingTypeId, Double price, Integer seats) {
		BookingType bt = bookingTypeRepository.findById(bookingTypeId).get();
		return new MoviePricing(bt, price, seats);
	}

	/* Assumption no modification allowed in StartTime */
	public void modifyMovietiming(Screen screen, ScheduleDto schedule) {
		var movietiming = screen.getMovietimings().stream()
				.filter(bu -> bu.getTimeslot().equals(schedule.getStartTime())).findAny().orElse(null);
		if (movietiming == null) {
			// new details are there...
			movietiming = getNewMovieTiming(schedule);
		} else {
			movietiming.setMovieId(schedule.getMovieId());
			for (PriceQunatityDetail pqd : schedule.getPriceQunatityDetail()) {
				MoviePricing bud = movietiming.getMovietimings().stream()
						.filter(ud -> ud.getBookingType().getId().equals(pqd.getBookingTypeId())).findAny()
						.orElse(null);
				if (bud == null) {
					movietiming.addMoviePricingDetails(
							getNewMoviePricing(pqd.getBookingTypeId(), pqd.getPrice(), pqd.getSeats()));
				} else {
					bud.setPrice(pqd.getPrice());
					bud.setCapacity(pqd.getSeats());
				}
			}
		}
		screen.addMovieTiming(movietiming);
	}

}
