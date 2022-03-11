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
import com.mybooking.demo.constant.SystemConstants;

@Entity
@Table(name = "movie_pricing")
public class MoviePricing extends BaseModel {

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

	// Price of booking a single ticket for the above type
	private Double price;

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public MoviePricing() {
		super();
	}

	public MoviePricing(SeatCategory seatcategory, Double price) {
		super();
		var date = new Date();
		this.seatcategory = seatcategory;
		this.price = price;
		this.status = SystemConstants.STATUS_ACTIVE;
		this.created = 1;
		this.lastModified = 1;
		this.createdDate = date;
		this.lastModifiedDate = date;
	}

	public MoviePricing(Long id, MovieTimeslot movieTimeslot, SeatCategory seatcategory, Double price,
			String status, Integer created, Integer lastModified, Date createdDate, Date lastModifiedDate) {
		super();
		this.id = id;
		this.movieTimeslot = movieTimeslot;
		this.seatcategory = seatcategory;
		this.price = price;
		this.status = status;
		this.created = created;
		this.lastModified = lastModified;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "MoviePricing [id=" + id + ", price=" + price + ", status=" + status
				+ ", created=" + created + ", lastModified=" + lastModified + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
		result = prime * result + ((movieTimeslot == null) ? 0 : movieTimeslot.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((seatcategory == null) ? 0 : seatcategory.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoviePricing other = (MoviePricing) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (lastModifiedDate == null) {
			if (other.lastModifiedDate != null)
				return false;
		} else if (!lastModifiedDate.equals(other.lastModifiedDate))
			return false;
		if (movieTimeslot == null) {
			if (other.movieTimeslot != null)
				return false;
		} else if (!movieTimeslot.equals(other.movieTimeslot))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (seatcategory == null) {
			if (other.seatcategory != null)
				return false;
		} else if (!seatcategory.equals(other.seatcategory))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
