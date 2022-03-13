package com.mybooking.demo.dto.booking;

public class PaymentDetailDTO {

	private Long paymentId;
	private Long purchaseId;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public PaymentDetailDTO(Long paymentId, Long purchaseId) {
		super();
		this.paymentId = paymentId;
		this.purchaseId = purchaseId;
	}

	public PaymentDetailDTO() {
		super();
	}

	@Override
	public String toString() {
		return "PaymentDetailDTO [paymentId=" + paymentId + ", purchaseId=" + purchaseId + "]";
	}

}
