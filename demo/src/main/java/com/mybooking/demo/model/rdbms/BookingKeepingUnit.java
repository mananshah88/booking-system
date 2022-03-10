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
@Table(name = "bookingkeepingunit")
public class BookingKeepingUnit extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("screen")
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "screenId")
	private Screen screen;

	// logical-foreign key on Movie -> id
	private String movieId;

	// Movie start time
	private Date timeslot;

	// Booking Type ( Seat type)
	@JsonProperty("bookingType")
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookingTypeId")
	private BookingType bookingType;

	private String status = SystemConstants.STATUS_ACTIVE;
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

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public Date getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(Date timeslot) {
		this.timeslot = timeslot;
	}

	public BookingType getBookingType() {
		return bookingType;
	}

	public void setBookingType(BookingType bookingType) {
		this.bookingType = bookingType;
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

	public BookingKeepingUnit() {
		super();
	}

	public BookingKeepingUnit(Long id, Screen screen, String movieId, Date timeslot, BookingType bookingType, String status,
			Integer created, Integer lastModified, Date createdDate, Date lastModifiedDate) {
		super();
		this.id = id;
		this.screen = screen;
		this.movieId = movieId;
		this.timeslot = timeslot;
		this.bookingType = bookingType;
		this.status = status;
		this.created = created;
		this.lastModified = lastModified;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "BookingKeepingUnit [id=" + id + ", movieId=" + movieId + ", timeslot=" + timeslot + ", status=" + status
				+ ", created=" + created + ", lastModified=" + lastModified + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}

}
