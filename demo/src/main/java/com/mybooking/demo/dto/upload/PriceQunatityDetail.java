package com.mybooking.demo.dto.upload;

public class PriceQunatityDetail {

	private Long bookingTypeId;
	private Double price;
	private Integer seats;

	public Long getBookingTypeId() {
		return bookingTypeId;
	}

	public void setBookingTypeId(Long bookingTypeId) {
		this.bookingTypeId = bookingTypeId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public PriceQunatityDetail() {
		super();
	}

	public PriceQunatityDetail(Long bookingTypeId, Double price, Integer seats) {
		super();
		this.bookingTypeId = bookingTypeId;
		this.price = price;
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "PriceQunatityDetails [bookingTypeId=" + bookingTypeId + ", price=" + price + ", seats=" + seats + "]";
	}

}
