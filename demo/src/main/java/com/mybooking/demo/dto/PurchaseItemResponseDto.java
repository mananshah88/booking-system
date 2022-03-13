package com.mybooking.demo.dto;

public class PurchaseItemResponseDto {

	private Long seatId;
	private Double price;

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public PurchaseItemResponseDto() {
		super();
	}

	public PurchaseItemResponseDto(Long seatId, Double price) {
		super();
		this.seatId = seatId;
		this.price = price;
	}

	@Override
	public String toString() {
		return "PurchaseItemResponseDto [seatId=" + seatId + ", price=" + price + "]";
	}

}
