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
	private List<Integer> cities;
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

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", title=" + title + ", thumbnailUrl=" + thumbnailUrl
				+ ", treasureLink=" + treasureLink + ", trailerLink=" + trailerLink + ", description=" + description
				+ ", languages=" + languages + ", genres=" + genres + ", cities=" + cities + ", formats=" + formats
				+ ", timeDuration=" + timeDuration + ", certificate=" + certificate + ", releaseDate=" + releaseDate
				+ ", team=" + team + "]";
	}

	public Movie(String id, String name, String title, String thumbnailUrl, String treasureLink, String trailerLink,
			String description, List<String> languages, List<String> genres, List<Integer> cities, List<String> formats,
			Integer timeDuration, String certificate, Date releaseDate, List<CrewMember> team) {
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
		this.cities = cities;
		this.formats = formats;
		this.timeDuration = timeDuration;
		this.certificate = certificate;
		this.releaseDate = releaseDate;
		this.team = team;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((certificate == null) ? 0 : certificate.hashCode());
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((formats == null) ? 0 : formats.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		result = prime * result + ((thumbnailUrl == null) ? 0 : thumbnailUrl.hashCode());
		result = prime * result + ((timeDuration == null) ? 0 : timeDuration.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((trailerLink == null) ? 0 : trailerLink.hashCode());
		result = prime * result + ((treasureLink == null) ? 0 : treasureLink.hashCode());
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
		Movie other = (Movie) obj;
		if (certificate == null) {
			if (other.certificate != null)
				return false;
		} else if (!certificate.equals(other.certificate))
			return false;
		if (cities == null) {
			if (other.cities != null)
				return false;
		} else if (!cities.equals(other.cities))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (formats == null) {
			if (other.formats != null)
				return false;
		} else if (!formats.equals(other.formats))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		if (thumbnailUrl == null) {
			if (other.thumbnailUrl != null)
				return false;
		} else if (!thumbnailUrl.equals(other.thumbnailUrl))
			return false;
		if (timeDuration == null) {
			if (other.timeDuration != null)
				return false;
		} else if (!timeDuration.equals(other.timeDuration))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (trailerLink == null) {
			if (other.trailerLink != null)
				return false;
		} else if (!trailerLink.equals(other.trailerLink))
			return false;
		if (treasureLink == null) {
			if (other.treasureLink != null)
				return false;
		} else if (!treasureLink.equals(other.treasureLink))
			return false;
		return true;
	}

}
