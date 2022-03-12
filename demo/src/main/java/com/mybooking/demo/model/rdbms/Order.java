package com.mybooking.demo.model.rdbms;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mybooking.demo.base.BaseModel;
import com.mybooking.demo.constant.SystemConstants;

@Entity
@Table(name = "orders")
public class Order extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("purchase")
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchaseId")
	private Purchase purchase;

	private Long paymentId;

	private String status;
	private Integer created;
	private Integer lastModified;
	private Date createdDate;
	private Date lastModifiedDate = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public Integer getLastModified() {
		return lastModified;
	}

	public void setLastModified(Integer lastModified) {
		this.lastModified = lastModified;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Order() {
		super();
	}

	public Order(Purchase purchase, Long paymentId) {
		super();
		this.purchase = purchase;
		this.paymentId = paymentId;
		this.status = SystemConstants.STATUS_ACTIVE;
		this.created = getLoggedInCustomerId();
		this.lastModified = getLoggedInCustomerId();
		this.createdDate = getCurrentDateTime();
		this.lastModifiedDate = getCurrentDateTime();
	}

	public Order(Long id, Purchase purchase, Long paymentId, String status, Integer created, Integer lastModified,
			Date createdDate, Date lastModifiedDate) {
		super();
		this.id = id;
		this.purchase = purchase;
		this.paymentId = paymentId;
		this.status = status;
		this.created = created;
		this.lastModified = lastModified;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", paymentId=" + paymentId + ", status=" + status + ", created=" + created
				+ ", lastModified=" + lastModified + ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + "]";
	}

}
