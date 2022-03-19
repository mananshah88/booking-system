package com.mybooking.demo.model.rdbms;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.mybooking.demo.base.BaseModel;
import com.mybooking.demo.constant.BaseConstants;

@Entity
@Table(name = "seat_reservation")
public class SeatReservation extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Require only for Optimistic lock
//	@Version
//	private Long version;

	private Integer seatId;
	private Integer bookingStatus;

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

//	public Long getVersion() {
//		return version;
//	}
//
//	public void setVersion(Long version) {
//		this.version = version;
//	}

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public Integer getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Integer bookingStatus) {
		this.bookingStatus = bookingStatus;
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

	public SeatReservation(Long id, Integer seatId, Integer bookingStatus, Integer customerId,
			Date date) {
		super();
		this.id = id;
//		this.version = version;
		this.seatId = seatId;
		this.bookingStatus = bookingStatus;
		this.status = BaseConstants.STATUS_ACTIVE;
		this.created = customerId;
		this.lastModified = customerId;
		this.createdDate = date;
		this.lastModifiedDate = date;
	}

	public SeatReservation() {
		super();
	}

	@Override
	public String toString() {
		return "SeatReservation [id=" + id + ", seatId=" + seatId + ", bookingStatus=" + bookingStatus + ", status="
				+ status + ", created=" + created + ", lastModified=" + lastModified + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}

}
