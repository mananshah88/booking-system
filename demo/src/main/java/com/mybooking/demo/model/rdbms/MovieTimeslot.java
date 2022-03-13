package com.mybooking.demo.model.rdbms;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mybooking.demo.base.BaseModel;
import com.mybooking.demo.constant.BaseConstants;

@Entity
@Table(name = "movie_timeslot")
public class MovieTimeslot extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "screenId", nullable = false)
	private Screen screen;

	// logical-foreign key on Movie -> id
	private String movieId;

	// Movie start time
	private Date timeslot;

	@JsonProperty("timeslotSeatDetails")
	@OneToMany(mappedBy = "movieTimeslot", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<SeatDetails> seatDetails = new HashSet<>();

	private String status = BaseConstants.STATUS_ACTIVE;
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

	public Set<SeatDetails> getSeatDetails() {
		return seatDetails;
	}

	public void setSeatDetails(Set<SeatDetails> seatDetails) {
		this.seatDetails = seatDetails;
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

	public MovieTimeslot() {
		super();
	}

	public MovieTimeslot(String movieId, Date timeslot, Integer customerId, Date date) {
		super();
		this.movieId = movieId;
		this.timeslot = timeslot;
		this.status = BaseConstants.STATUS_ACTIVE;
		this.created = customerId;
		this.lastModified = customerId;
		this.createdDate = date;
		this.lastModifiedDate = date;
	}

	@Override
	public String toString() {
		return "MovieTimeslot [id=" + id + ", movieId=" + movieId + ", timeslot=" + timeslot + ", status=" + status
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
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
		result = prime * result + ((screen == null) ? 0 : screen.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((timeslot == null) ? 0 : timeslot.hashCode());
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
		MovieTimeslot other = (MovieTimeslot) obj;
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
		if (movieId == null) {
			if (other.movieId != null)
				return false;
		} else if (!movieId.equals(other.movieId))
			return false;
		if (screen == null) {
			if (other.screen != null)
				return false;
		} else if (!screen.equals(other.screen))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (timeslot == null) {
			if (other.timeslot != null)
				return false;
		} else if (!timeslot.equals(other.timeslot))
			return false;
		return true;
	}

	public void addTimeslotSeatDetails(SeatDetails tsd) {
		seatDetails.add(tsd);
		tsd.setMovieTimeslot(this);
	}

	public void removeTimeslotSeatDetails(SeatDetails tsd) {
		seatDetails.remove(tsd);
		tsd.setMovieTimeslot(null);
	}

}
