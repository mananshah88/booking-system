package com.mybooking.demo.dto;

public class PromotionRequestDto {

	private Long purchaseId;
	private String promotionCode;

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public PromotionRequestDto(Long purchaseId, String promotionCode) {
		super();
		this.purchaseId = purchaseId;
		this.promotionCode = promotionCode;
	}

	public PromotionRequestDto() {
		super();
	}

	@Override
	public String toString() {
		return "PromotionRequestDto [purchaseId=" + purchaseId + ", promotionCode=" + promotionCode + "]";
	}

}
