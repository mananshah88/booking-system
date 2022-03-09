package com.mybooking.demo.dto.partner;

public class ScreenRequestDto {

	private String name;
	private Integer capacity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public ScreenRequestDto() {
		super();
	}

	public ScreenRequestDto(String name, Integer capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "ScreenRequestDto [name=" + name + ", capacity=" + capacity + "]";
	}

}
