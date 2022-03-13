package com.mybooking.demo.dto.search;

public class SearchResponseDto {

	private String name;
	private String thumbnailUrl;
	private String title;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SearchResponseDto(String name, String thumbnailUrl, String title) {
		super();
		this.name = name;
		this.thumbnailUrl = thumbnailUrl;
		this.title = title;
	}

	public SearchResponseDto() {
		super();
	}

	@Override
	public String toString() {
		return "SearchResponseDto [name=" + name + ", thumbnailUrl=" + thumbnailUrl + ", title=" + title + "]";
	}

}
