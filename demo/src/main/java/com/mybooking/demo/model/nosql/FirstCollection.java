package com.mybooking.demo.model.nosql;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "firstcollection")
public class FirstCollection {

	@Id
	@GeneratedValue
	private String id;
	private String name;

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

	public FirstCollection(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public FirstCollection() {
		super();
	}

	@Override
	public String toString() {
		return "FirstCollection [id=" + id + ", name=" + name + "]";
	}

}
