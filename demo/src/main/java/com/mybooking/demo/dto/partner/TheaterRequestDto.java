package com.mybooking.demo.dto.partner;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TheaterRequestDto {

	@NotBlank(message = "Name must not be null or empty")
	private String name;
	
	@NotNull(message = "CityId must not be null")
	private Integer cityId;
	
	@NotBlank(message = "Address must not be null or empty")
	private String address;
	
	private Double pincode;
	
	@Size(min = 1, message = "At least one screen is require for on boarding")
	private List<ScreenRequestDto> screens;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getPincode() {
		return pincode;
	}

	public void setPincode(Double pincode) {
		this.pincode = pincode;
	}

	public List<ScreenRequestDto> getScreens() {
		return screens;
	}

	public void setScreens(List<ScreenRequestDto> screens) {
		this.screens = screens;
	}

	public TheaterRequestDto(String name, Integer cityId, String address, Double pincode,
			List<ScreenRequestDto> screens) {
		super();
		this.name = name;
		this.cityId = cityId;
		this.address = address;
		this.pincode = pincode;
		this.screens = screens;
	}

	public TheaterRequestDto() {
		super();
	}

	@Override
	public String toString() {
		return "TheaterRequestDto [name=" + name + ", cityId=" + cityId + ", address=" + address + ", pincode="
				+ pincode + ", screens=" + screens + "]";
	}

}
