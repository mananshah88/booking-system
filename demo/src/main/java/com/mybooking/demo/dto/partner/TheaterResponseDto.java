package com.mybooking.demo.dto.partner;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import com.mybooking.demo.model.rdbms.Screen;

public class TheaterResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long theaterId;
	private String name;
	private Integer partnerId;
	private Map<Long, String> screensMap;
	private Integer cityId;

	public Long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Long theaterId) {
		this.theaterId = theaterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public Map<Long, String> getScreensMap() {
		return screensMap;
	}

	public void setScreensMap(Map<Long, String> screensMap) {
		this.screensMap = screensMap;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public TheaterResponseDto() {
		super();
	}

	public TheaterResponseDto(Long theaterId, String name, Integer partnerId, Map<Long, String> screensMap,
			Integer cityId) {
		super();
		this.theaterId = theaterId;
		this.name = name;
		this.partnerId = partnerId;
		this.screensMap = screensMap;
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "TheaterResponseDto [theaterId=" + theaterId + ", name=" + name + ", partnerId=" + partnerId
				+ ", screensMap=" + screensMap + ", cityId=" + cityId + "]";
	}

}
