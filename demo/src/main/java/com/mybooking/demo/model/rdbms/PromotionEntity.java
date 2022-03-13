package com.mybooking.demo.model.rdbms;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mybooking.demo.base.BaseModel;

@Entity
@Table(name = "promotion_entity")
public class PromotionEntity extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "promotionId", nullable = false)
	private Promotion promotion;

	private String entityType;
	private Integer entityValue;
	private String entityOperator;
	private String promotionType;
	private BigDecimal promotionValue;

	private String status;
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

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public Integer getEntityValue() {
		return entityValue;
	}

	public void setEntityValue(Integer entityValue) {
		this.entityValue = entityValue;
	}

	public String getEntityOperator() {
		return entityOperator;
	}

	public void setEntityOperator(String entityOperator) {
		this.entityOperator = entityOperator;
	}

	public String getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	public BigDecimal getPromotionValue() {
		return promotionValue;
	}

	public void setPromotionValue(BigDecimal promotionValue) {
		this.promotionValue = promotionValue;
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

	public PromotionEntity() {
		super();
	}

	public PromotionEntity(Long id, Promotion promotion, String entityType, Integer entityValue, String entityOperator,
			String promotionType, BigDecimal promotionValue, String status, Integer created, Integer lastModified,
			Date createdDate, Date lastModifiedDate) {
		super();
		this.id = id;
		this.promotion = promotion;
		this.entityType = entityType;
		this.entityValue = entityValue;
		this.entityOperator = entityOperator;
		this.promotionType = promotionType;
		this.promotionValue = promotionValue;
		this.status = status;
		this.created = created;
		this.lastModified = lastModified;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "PromotionEntity [id=" + id + ", promotion=" + promotion + ", entityType=" + entityType
				+ ", entityValue=" + entityValue + ", entityOperator=" + entityOperator + ", promotionType="
				+ promotionType + ", promotionValue=" + promotionValue + ", status=" + status + ", created=" + created
				+ ", lastModified=" + lastModified + ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + "]";
	}

}
