package com.mybooking.demo.dto;

import java.math.BigDecimal;

public class PurchaseItemResponseDto {

	private Long seatId;
	private BigDecimal price;

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public PurchaseItemResponseDto() {
		super();
	}

	public PurchaseItemResponseDto(Long seatId, BigDecimal price) {
		super();
		this.seatId = seatId;
		this.price = price;
	}

	@Override
	public String toString() {
		return "PurchaseItemResponseDto [seatId=" + seatId + ", price=" + price + "]";
	}

}
