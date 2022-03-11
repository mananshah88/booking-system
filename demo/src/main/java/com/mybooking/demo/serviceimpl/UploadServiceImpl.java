package com.mybooking.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybooking.demo.dto.upload.PriceQunatityDetail;
import com.mybooking.demo.dto.upload.ScheduleDto;
import com.mybooking.demo.dto.upload.UploadRequestDTO;
import com.mybooking.demo.model.rdbms.BookingType;
import com.mybooking.demo.model.rdbms.BookingUnit;
import com.mybooking.demo.model.rdbms.BookingUnitDetails;
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
			screenDto.getSchedule().forEach(schedule -> screen.addBookingUnit(getNewBookingUnit(schedule)));
			screenRepository.save(screen);
		});

		return true;
	}

	// MANAN
	@Override
	public Boolean modifyDetails(UploadRequestDTO uploadRequestDTO) {
		uploadRequestDTO.getScreens().forEach(screenDto -> {
			var screen = screenRepository.findById(screenDto.getScreenId()).get();
			screenDto.getSchedule().forEach(schedule -> modifyBookingUnit(screen, schedule));
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

	public BookingUnit getNewBookingUnit(ScheduleDto schedule) {
		var bookingUnit = new BookingUnit(schedule.getMovieId(), schedule.getStartTime());
		schedule.getPriceQunatityDetail().forEach(detail -> bookingUnit.addBookingUnitDetails(
				getNewBookingUnitDetails(detail.getBookingTypeId(), detail.getPrice(), detail.getSeats())));
		return bookingUnit;
	}

	public BookingUnitDetails getNewBookingUnitDetails(Long bookingTypeId, Double price, Integer seats) {
		BookingType bt = bookingTypeRepository.findById(bookingTypeId).get();
		return new BookingUnitDetails(bt, price, seats);
	}

	/* Assumption no modification allowed in StartTime*/
	public void modifyBookingUnit(Screen screen, ScheduleDto schedule) {
		BookingUnit bookingUnit = screen.getBookingUnits().stream()
				.filter(bu -> bu.getTimeslot().equals(schedule.getStartTime())).findAny().orElse(null);
		if(bookingUnit==null) {
			// new details are there...
			bookingUnit = getNewBookingUnit(schedule);
		} else {
			bookingUnit.setMovieId(schedule.getMovieId());
			for(PriceQunatityDetail pqd: schedule.getPriceQunatityDetail()) {
				BookingUnitDetails bud = bookingUnit.getUnitdetails().stream()
						.filter(ud -> ud.getBookingType().getId().equals(pqd.getBookingTypeId())).findAny().orElse(null);
				if (bud == null) {
					bookingUnit.addBookingUnitDetails(
							getNewBookingUnitDetails(pqd.getBookingTypeId(), pqd.getPrice(), pqd.getSeats()));
				} else {
					bud.setPrice(pqd.getPrice());
					bud.setCapacity(pqd.getSeats());
				}
			}
		}
		screen.addBookingUnit(bookingUnit);
	}
}
