package com.mybooking.demo.serviceimpl;

import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;

@Service
public class UploadServiceImpl extends BaseServiceImpl {
//public class UploadServiceImpl extends BaseServiceImpl implements UploadService {
//
//	private ScreenRepository screenRepository;
//
//	@Autowired
//	public UploadServiceImpl(ScreenRepository screenRepository) {
//		this.screenRepository = screenRepository;
//	}
//
//	/*
//	 * Assumption: Token is valid Authorization is done
//	 * 
//	 * @Valid annotation to requested DTO and it also has all the validations by
//	 * annotated
//	 */
//	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 2, readOnly = false, rollbackFor = Exception.class)
//	@Override
//	public Boolean uploadDetails(UploadRequestDTO uploadRequestDTO) {
//
//		/*
//		 * if(!isValidTheater(uploadRequestDTO.getTheaterId())) { throw new
//		 * InvalidTheaterException("InValid Theater"); }
//		 * if(!areValidScreens(uploadRequestDTO.getTheaterId().getScreens())) { throw
//		 * new InvalidScreenException("InValid Screen"); }
//		 */
//
//		uploadRequestDTO.getScreens().forEach(screenDto -> {
//			var screen = screenRepository.findById(screenDto.getScreenId()).get();
//			screenDto.getSchedule().forEach(schedule -> screen.addMovieTiming(getNewMovieTiming(schedule)));
//			screenRepository.save(screen);
//		});
//
//		return true;
//	}
//
//	// MANAN
//	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 2, readOnly = false, rollbackFor = Exception.class)
//	@Override
//	public Boolean modifyDetails(UploadRequestDTO uploadRequestDTO) {
//		uploadRequestDTO.getScreens().forEach(screenDto -> {
//			var screen = screenRepository.findById(screenDto.getScreenId()).get();
//			screenDto.getSchedule().forEach(schedule -> modifyMovietiming(screen, schedule));
//			screenRepository.save(screen);
//		});
//		return true;
//	}
//
//	public boolean isValidTheater(Integer theaterId) {
//		// check DB has that valued and it is own by the same Partner(Loggedin User)
//		return true;
//	}
//
//	public boolean areValidScreens(List<Integer> screenIds) {
//		// check DB has that value and it is own by the same Partner(Loggedin User)
//		return true;
//	}
//
//	public boolean areValidScheduledStartTime() {
//		return true;
//	}
//
//	public boolean areValidMovies() {
//		return true;
//	}
//
//	public boolean areValidPriceQuantityDetails() {
//		return true;
//	}
//
//	public MovieTimeslot getNewMovieTiming(ScheduleDto schedule) {
//		var movietiming = new MovieTimeslot(schedule.getMovieId(), schedule.getStartTime());
//		schedule.getPriceQunatityDetail().forEach(detail -> movietiming.addTimeslotPricing(
//				getNewMoviePricing(detail.getBookingTypeId(), detail.getPrice(), detail.getSeats())));
//		return movietiming;
//	}
//
//	public TimeslotPricing getNewMoviePricing(Long bookingTypeId, Double price, Integer seats) {
//		SeatCategory bt = seatCategoryRepository.findById(bookingTypeId).get();
//		return new TimeslotPricing(bt, price);
//	}
//
//	/* Assumption no modification allowed in StartTime */
//	public void modifyMovietiming(Screen screen, ScheduleDto schedule) {
//		MovieTimeslot movietiming = screen.getMovietimeslots().stream()
//				.filter(bu -> bu.getTimeslot().equals(schedule.getStartTime())).findAny().orElse(null);
//		if (movietiming == null) {
//			// new details are there...
//			movietiming = getNewMovieTiming(schedule);
//		} else {
//			movietiming.setMovieId(schedule.getMovieId());
//			for (PriceQunatityDetail pqd : schedule.getPriceQunatityDetail()) {
//				TimeslotPricing bud = movietiming.getTimeslotPricing().stream()
//						.filter(ud -> ud.getSeatcategory().getId().equals(pqd.getBookingTypeId())).findAny()
//						.orElse(null);
//				if (bud == null) {
//					movietiming.addTimeslotPricing(
//							getNewMoviePricing(pqd.getBookingTypeId(), pqd.getPrice(), pqd.getSeats()));
//				} else {
//					bud.setPrice(pqd.getPrice());
//				}
//			}
//		}
//		screen.addMovieTiming(movietiming);
//	}
}
