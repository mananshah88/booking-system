package com.mybooking.demo.model.nosql;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.mybooking.demo.base.BaseModel;

public class Review extends BaseModel {

	/* Default SerialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;
	private String text;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Review() {
	}

	public Review(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", text=" + text + "]";
	}

}
