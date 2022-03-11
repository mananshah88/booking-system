package com.mybooking.demo.model.rdbms;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mybooking.demo.base.BaseModel;

@Entity
@Table(name = "timeslot_seat_details")
public class TimeslotSeatDetails extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "movietimeslotId", nullable = false)
	private MovieTimeslot movieTimeslot;

	// Booking Type ( Seat type)
	@JsonProperty("seatcategory")
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seatcategoryId")
	private SeatCategory seatcategory;

	// seat position: row number
	private Integer positionRowNo;

	// seat position: number in the row
	private Integer positionOrderFromLeft;

	// seat position displayname: A1, A2, etc
	private String seatNo;

	// booking status
	private Boolean booked;

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

	public MovieTimeslot getMovieTimeslot() {
		return movieTimeslot;
	}

	public void setMovieTimeslot(MovieTimeslot movieTimeslot) {
		this.movieTimeslot = movieTimeslot;
	}

	public SeatCategory getSeatcategory() {
		return seatcategory;
	}

	public void setSeatcategory(SeatCategory seatcategory) {
		this.seatcategory = seatcategory;
	}

	public Integer getPositionRowNo() {
		return positionRowNo;
	}

	public void setPositionRowNo(Integer positionRowNo) {
		this.positionRowNo = positionRowNo;
	}

	public Integer getPositionOrderFromLeft() {
		return positionOrderFromLeft;
	}

	public void setPositionOrderFromLeft(Integer positionOrderFromLeft) {
		this.positionOrderFromLeft = positionOrderFromLeft;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public Boolean getBooked() {
		return booked;
	}

	public void setBooked(Boolean booked) {
		this.booked = booked;
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

	public TimeslotSeatDetails() {
		super();
	}

	public TimeslotSeatDetails(Long id, MovieTimeslot movieTimeslot, SeatCategory seatcategory, Integer positionRowNo,
			Integer positionOrderFromLeft, String seatNo, Boolean booked, String status, Integer created,
			Integer lastModified, Date createdDate, Date lastModifiedDate) {
		super();
		this.id = id;
		this.movieTimeslot = movieTimeslot;
		this.seatcategory = seatcategory;
		this.positionRowNo = positionRowNo;
		this.positionOrderFromLeft = positionOrderFromLeft;
		this.seatNo = seatNo;
		this.booked = booked;
		this.status = status;
		this.created = created;
		this.lastModified = lastModified;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "TimeslotSeatDetails [id=" + id + ", positionRowNo=" + positionRowNo + ", positionOrderFromLeft="
				+ positionOrderFromLeft + ", seatNo=" + seatNo + ", booked=" + booked + ", status=" + status
				+ ", created=" + created + ", lastModified=" + lastModified + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}

}
