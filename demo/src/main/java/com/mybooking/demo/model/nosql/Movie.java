package com.mybooking.demo.model.nosql;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mybooking.demo.base.BaseModel;

@Document(collection = "movie")
public class Movie extends BaseModel {

	/* Default SerialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;
	
	/* Movie Name and Title (Display purpose) */
	private String name;  // e.g: The Batman
	private String title;  // e.g: The Batman

	/*
	 * Movie Poster Image URL 
	 * Any image url can work but scaling point of view it should be CDN URL
	 */
	private String thumbnailUrl;

	/*
	 * Movie Trailer/Treasure URL. 
	 * Any video url can work but scaling point of view it should be CDN URL (or youtube/vimeo/other hosted video URL )
	 */
	private String treasureLink; 
	private String trailerLink;
	
	/* Movie Description*/
	private String description;
	private List<String> languages;
	private List<String> genres;
	private List<String> formats;

	/* TimeDuration In minutes */
	private Integer timeDuration;
	private String certificate;
	private Date releaseDate;

	/* Movie Cast and Crew Details */
	private List<CrewMember> team;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getTreasureLink() {
		return treasureLink;
	}

	public void setTreasureLink(String treasureLink) {
		this.treasureLink = treasureLink;
	}

	public String getTrailerLink() {
		return trailerLink;
	}

	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public List<String> getFormats() {
		return formats;
	}

	public void setFormats(List<String> formats) {
		this.formats = formats;
	}

	public Integer getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(Integer timeDuration) {
		this.timeDuration = timeDuration;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public List<CrewMember> getTeam() {
		return team;
	}

	public void setTeam(List<CrewMember> team) {
		this.team = team;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Movie() {
		super();
	}

	public Movie(String id, String name, String title, String thumbnailUrl, String treasureLink, String trailerLink,
			String description, List<String> languages, List<String> genres, List<String> formats, Integer timeDuration,
			String certificate, List<CrewMember> team, Date releaseDate) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.thumbnailUrl = thumbnailUrl;
		this.treasureLink = treasureLink;
		this.trailerLink = trailerLink;
		this.description = description;
		this.languages = languages;
		this.genres = genres;
		this.formats = formats;
		this.timeDuration = timeDuration;
		this.certificate = certificate;
		this.team = team;
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", title=" + title + ", thumbnailUrl=" + thumbnailUrl
				+ ", treasureLink=" + treasureLink + ", trailerLink=" + trailerLink + ", description=" + description
				+ ", languages=" + languages + ", genres=" + genres + ", formats=" + formats + ", timeDuration="
				+ timeDuration + ", certificate=" + certificate + ", team=" + team + ", releaseDate=" + releaseDate
				+ "]";
	}

}
