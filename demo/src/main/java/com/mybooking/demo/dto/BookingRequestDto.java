package com.mybooking.demo.dto;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class BookingRequestDto {

	@Positive(message = "TheaterId must be greater than 1")
	private Long theaterId;

	@Positive(message = "ScreenId must be greater than 1")
	private Long screenId;

	@Future(message = "bookingDate must be of future")
	private Date bookingDateTimeSlot;

	@Size(min = 1, message = "For booking, at least one ticket is require")
	private Set<@Positive(message = "Seat No must be positive") Long> seatIds;

	public Long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Long theaterId) {
		this.theaterId = theaterId;
	}

	public Long getScreenId() {
		return screenId;
	}

	public void setScreenId(Long screenId) {
		this.screenId = screenId;
	}

	public Date getBookingDateTimeSlot() {
		return bookingDateTimeSlot;
	}

	public void setBookingDateTimeSlot(Date bookingDateTimeSlot) {
		this.bookingDateTimeSlot = bookingDateTimeSlot;
	}

	public Set<Long> getSeatIds() {
		return seatIds;
	}

	public void setSeatIds(Set<Long> seatIds) {
		this.seatIds = seatIds;
	}

	public BookingRequestDto() {
		super();
	}

	public BookingRequestDto(@Positive(message = "TheaterId must be greater than 1") Long theaterId,
			@Positive(message = "ScreenId must be greater than 1") Long screenId,
			@Future(message = "bookingDate must be of future") Date bookingDateTimeSlot,
			@Size(min = 1, message = "For booking, at least one ticket is require") Set<@Positive(message = "Seat No must be positive") Long> seatIds) {
		super();
		this.theaterId = theaterId;
		this.screenId = screenId;
		this.bookingDateTimeSlot = bookingDateTimeSlot;
		this.seatIds = seatIds;
	}

	@Override
	public String toString() {
		return "BookingRequestDto [theaterId=" + theaterId + ", screenId=" + screenId + ", bookingDateTimeSlot="
				+ bookingDateTimeSlot + ", seatIds=" + seatIds + "]";
	}

}
