package com.mybooking.demo.dto;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseResponseDto {

	private Long orderId;
	private Long purchaseId;
	private Integer quantity;
	private BigDecimal totalamount;
	private BigDecimal tax;
	private String promotionCode;
	private BigDecimal discount;
	private BigDecimal payableamount;
	private List<PurchaseItemResponseDto> items;
	private String responseMessage;
	private String responseCode;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(BigDecimal totalamount) {
		this.totalamount = totalamount;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getPayableamount() {
		return payableamount;
	}

	public void setPayableamount(BigDecimal payableamount) {
		this.payableamount = payableamount;
	}

	public List<PurchaseItemResponseDto> getItems() {
		return items;
	}

	public void setItems(List<PurchaseItemResponseDto> items) {
		this.items = items;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public PurchaseResponseDto() {
		super();
	}

	public PurchaseResponseDto(String responseCode, String responseMessage) {
		super();
		this.responseMessage = responseMessage;
		this.responseCode = responseCode;
	}

	public PurchaseResponseDto(Long orderId, String responseCode, String responseMessage) {
		super();
		this.orderId = orderId;
		this.responseMessage = responseMessage;
		this.responseCode = responseCode;
	}

	public PurchaseResponseDto(Long purchaseId, Integer quantity, BigDecimal totalamount, BigDecimal tax,
			String promotionCode, BigDecimal discount, BigDecimal payableamount, List<PurchaseItemResponseDto> items,
			String responseCode, String responseMessage) {
		super();
		this.purchaseId = purchaseId;
		this.quantity = quantity;
		this.totalamount = totalamount;
		this.tax = tax;
		this.promotionCode = promotionCode;
		this.discount = discount;
		this.payableamount = payableamount;
		this.items = items;
		this.responseMessage = responseMessage;
		this.responseCode = responseCode;
	}

	@Override
	public String toString() {
		return "PurchaseResponseDto [purchaseId=" + purchaseId + ", quantity=" + quantity + ", totalamount="
				+ totalamount + ", tax=" + tax + ", promotionCode=" + promotionCode + ", discount=" + discount
				+ ", payableamount=" + payableamount + ", items=" + items + ", responseMessage=" + responseMessage
				+ ", responseCode=" + responseCode + "]";
	}

}
