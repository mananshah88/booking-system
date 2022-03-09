package com.mybooking.demo.model.cache;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("firstcache")
public class FirstCache implements Serializable {

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

	public FirstCache(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public FirstCache() {
		super();
	}

	@Override
	public String toString() {
		return "FirstCache [id=" + id + ", name=" + name + "]";
	}

}