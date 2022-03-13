package com.mybooking.demo.model.rdbms;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mybooking.demo.base.BaseModel;
import com.mybooking.demo.constant.BaseConstants;

@Entity
@Table(name = "theater")
public class Theater extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	/* Customer Table's id */
	private Integer partnerId;

	@JsonProperty("screens")
	@OneToMany(mappedBy = "theater", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Screen> screens = new HashSet<>();

	private Integer cityId;
	private String address;
	private Double pincode;

	private String status = BaseConstants.STATUS_ACTIVE;
	private Integer created;
	private Integer lastModified;
	private Date createdDate;
	private Date lastModifiedDate = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public Set<Screen> getScreens() {
		return screens;
	}

	public void setScreens(Set<Screen> screens) {
		this.screens = screens;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public Integer getLastModified() {
		return lastModified;
	}

	public void setLastModified(Integer lastModified) {
		this.lastModified = lastModified;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Theater() {
		super();
	}

	public Theater(String name, Integer partnerId, Integer cityId, String address, Double pincode, Integer customerId,
			Date date) {
		super();
		this.name = name;
		this.partnerId = partnerId;
		this.cityId = cityId;
		this.address = address;
		this.pincode = pincode;
		this.status = BaseConstants.STATUS_ACTIVE;
		this.created = customerId;
		this.lastModified = customerId;
		this.createdDate = date;
		this.lastModifiedDate = date;
	}

	@Override
	public String toString() {
		return "Theater [id=" + id + ", name=" + name + ", partnerId=" + partnerId + ", screens=" + screens
				+ ", cityId=" + cityId + ", address=" + address + ", pincode=" + pincode + ", status=" + status
				+ ", created=" + created + ", lastModified=" + lastModified + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	public void addScreen(Screen screen) {
		screens.add(screen);
		screen.setTheater(this);
	}

	public void removeScreen(Screen screen) {
		screens.remove(screen);
		screen.setTheater(null);
	}

}
