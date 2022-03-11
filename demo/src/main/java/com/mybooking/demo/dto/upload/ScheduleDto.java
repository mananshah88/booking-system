package com.mybooking.demo.dto.upload;

import java.util.Date;
import java.util.List;

public class ScheduleDto {

	private Date startTime;
	private String movieId;
	private List<PriceQunatityDetail> priceQunatityDetail;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public List<PriceQunatityDetail> getPriceQunatityDetail() {
		return priceQunatityDetail;
	}

	public void setPriceQunatityDetail(List<PriceQunatityDetail> priceQunatityDetail) {
		this.priceQunatityDetail = priceQunatityDetail;
	}

	public ScheduleDto() {
		super();
	}

	public ScheduleDto(Date startTime, String movieId, List<PriceQunatityDetail> priceQunatityDetail) {
		super();
		this.startTime = startTime;
		this.movieId = movieId;
		this.priceQunatityDetail = priceQunatityDetail;
	}

	@Override
	public String toString() {
		return "Schedule [startTime=" + startTime + ", movieId=" + movieId + ", priceQunatityDetail=" + priceQunatityDetail
				+ "]";
	}

}
