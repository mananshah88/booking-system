package com.mybooking.demo.dto.upload;

import java.util.List;

public class ScreenDto {

	private Long screenId;
	private List<ScheduleDto> schedule;

	public Long getScreenId() {
		return screenId;
	}

	public void setScreenId(Long screenId) {
		this.screenId = screenId;
	}

	public List<ScheduleDto> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<ScheduleDto> schedule) {
		this.schedule = schedule;
	}

	public ScreenDto(Long screenId, List<ScheduleDto> schedule) {
		super();
		this.screenId = screenId;
		this.schedule = schedule;
	}

	public ScreenDto() {
		super();
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", schedule=" + schedule + "]";
	}

}