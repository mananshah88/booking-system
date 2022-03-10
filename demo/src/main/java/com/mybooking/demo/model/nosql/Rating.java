package com.mybooking.demo.model.nosql;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.mybooking.demo.base.BaseModel;

public class Rating extends BaseModel {

	/* Default SerialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;
	private String movieId;
	private Double ratings;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public Double getRatings() {
		return ratings;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Rating() {
	}

	public Rating(String id, String movieId, Double ratings) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", movieId=" + movieId + ", ratings=" + ratings + "]";
	}

}
