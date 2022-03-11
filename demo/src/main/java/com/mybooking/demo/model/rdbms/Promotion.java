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

@Entity
@Table(name = "promotion")
public class Promotion extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String promotionCode;
	private String name;
	private String description;

	@JsonProperty("entities")
	@OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<PromotionEntity> entities = new HashSet<>();

	@JsonProperty("restrictions")
	@OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<PromotionRestriction> restrictions = new HashSet<>();

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

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<PromotionEntity> getEntities() {
		return entities;
	}

	public void setEntities(Set<PromotionEntity> entities) {
		this.entities = entities;
	}

	public Set<PromotionRestriction> getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(Set<PromotionRestriction> restrictions) {
		this.restrictions = restrictions;
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

	public Promotion() {
		super();
	}

	public Promotion(Long id, String promotionCode, String name, String description, Set<PromotionEntity> entities,
			Set<PromotionRestriction> restrictions, Integer created, Integer lastModified, Date createdDate,
			Date lastModifiedDate) {
		super();
		this.id = id;
		this.promotionCode = promotionCode;
		this.name = name;
		this.description = description;
		this.entities = entities;
		this.restrictions = restrictions;
		this.created = created;
		this.lastModified = lastModified;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", promotionCode=" + promotionCode + ", name=" + name + ", description="
				+ description + ", created=" + created + ", lastModified=" + lastModified + ", createdDate="
				+ createdDate + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((entities == null) ? 0 : entities.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((promotionCode == null) ? 0 : promotionCode.hashCode());
		result = prime * result + ((restrictions == null) ? 0 : restrictions.hashCode());
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
		Promotion other = (Promotion) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (entities == null) {
			if (other.entities != null)
				return false;
		} else if (!entities.equals(other.entities))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (lastModifiedDate == null) {
			if (other.lastModifiedDate != null)
				return false;
		} else if (!lastModifiedDate.equals(other.lastModifiedDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (promotionCode == null) {
			if (other.promotionCode != null)
				return false;
		} else if (!promotionCode.equals(other.promotionCode))
			return false;
		if (restrictions == null) {
			if (other.restrictions != null)
				return false;
		} else if (!restrictions.equals(other.restrictions))
			return false;
		return true;
	}

	public void addPromotionEntity(PromotionEntity entity) {
		entities.add(entity);
		entity.setPromotion(this);
	}

	public void removePromotionEntity(PromotionEntity entity) {
		entities.remove(entity);
		entity.setPromotion(null);
	}

	public void addPromotionRestriction(PromotionRestriction restriction) {
		restrictions.add(restriction);
		restriction.setPromotion(this);
	}

	public void removePromotionRestriction(PromotionRestriction restriction) {
		restrictions.remove(restriction);
		restriction.setPromotion(null);
	}

}
