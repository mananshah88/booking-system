package com.mybooking.demo.model.nosql;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.mybooking.demo.base.BaseModel;

public class CrewMember extends BaseModel {

	/* Default SerialVersionUID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private String id;

	/* Artist/Crew Member name */
	private String name;
	private String title;
	/* type can be actor/actoress/Director/Music-Director etc */
	private String type;

	/* Any image url can work but scaling point of view it should be CDN URL */
	private String photoUrl;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CrewMember() {
		super();
	}

	public CrewMember(String id, String name, String title, String type, String photoUrl) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.type = type;
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		return "CrewMember [id=" + id + ", name=" + name + ", title=" + title + ", type=" + type + ", photoUrl="
				+ photoUrl + "]";
	}

}
