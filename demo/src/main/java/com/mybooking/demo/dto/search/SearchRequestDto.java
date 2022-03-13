package com.mybooking.demo.dto.search;

import java.util.List;

public class SearchRequestDto {

	private List<String> languages;
	private List<String> genres;
	private List<Integer> cities;

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<Integer> getCities() {
		return cities;
	}

	public void setCities(List<Integer> cities) {
		this.cities = cities;
	}

	public SearchRequestDto() {
		super();
	}

	public SearchRequestDto(List<String> languages, List<String> genres, List<Integer> cities) {
		super();
		this.languages = languages;
		this.genres = genres;
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "SearchRequestDto [languages=" + languages + ", genres=" + genres + ", cities=" + cities + "]";
	}

}
