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
@Table(name = "purchase")
public class Purchase extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("purchaseItems")
	@OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<PurchaseItem> purchaseItems = new HashSet<>();

	private Double priceOfSingleTicket;
	private Integer quantity;
	private Double totalamount;
	private Double tax;
	private String promotionCode;
	private Double discount;
	private Double payableamount;
	private String bookingStatus;

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

	public Set<PurchaseItem> getPurchaseItems() {
		return purchaseItems;
	}

	public void setPurchaseItems(Set<PurchaseItem> purchaseItems) {
		this.purchaseItems = purchaseItems;
	}

	public Double getPriceOfSingleTicket() {
		return priceOfSingleTicket;
	}

	public void setPriceOfSingleTicket(Double priceOfSingleTicket) {
		this.priceOfSingleTicket = priceOfSingleTicket;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getPayableamount() {
		return payableamount;
	}

	public void setPayableamount(Double payableamount) {
		this.payableamount = payableamount;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
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

	public Purchase() {
		super();
	}

	public Purchase(Long id, Double priceOfSingleTicket, Integer quantity, Double totalamount, Double tax,
			String promotionCode, Double discount, Double payableamount, String bookingStatus, String status,
			Integer created, Integer lastModified, Date createdDate, Date lastModifiedDate) {
		super();
		this.id = id;
		this.priceOfSingleTicket = priceOfSingleTicket;
		this.quantity = quantity;
		this.totalamount = totalamount;
		this.tax = tax;
		this.promotionCode = promotionCode;
		this.discount = discount;
		this.payableamount = payableamount;
		this.bookingStatus = bookingStatus;
		this.status = status;
		this.created = created;
		this.lastModified = lastModified;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", priceOfSingleTicket=" + priceOfSingleTicket + ", quantity=" + quantity
				+ ", totalamount=" + totalamount + ", tax=" + tax + ", promotionCode=" + promotionCode + ", discount="
				+ discount + ", payableamount=" + payableamount + ", bookingStatus=" + bookingStatus + ", status="
				+ status + ", created=" + created + ", lastModified=" + lastModified + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	public void addPurchaseItems(PurchaseItem purchaseItem) {
		purchaseItems.add(purchaseItem);
		purchaseItem.setPurchase(this);
	}

	public void removePurchaseItems(PurchaseItem purchaseItem) {
		purchaseItems.remove(purchaseItem);
		purchaseItem.setPurchase(null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingStatus == null) ? 0 : bookingStatus.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
		result = prime * result + ((payableamount == null) ? 0 : payableamount.hashCode());
		result = prime * result + ((priceOfSingleTicket == null) ? 0 : priceOfSingleTicket.hashCode());
		result = prime * result + ((promotionCode == null) ? 0 : promotionCode.hashCode());
		result = prime * result + ((purchaseItems == null) ? 0 : purchaseItems.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
		result = prime * result + ((totalamount == null) ? 0 : totalamount.hashCode());
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
		Purchase other = (Purchase) obj;
		if (bookingStatus == null) {
			if (other.bookingStatus != null)
				return false;
		} else if (!bookingStatus.equals(other.bookingStatus))
			return false;
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
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
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
		if (payableamount == null) {
			if (other.payableamount != null)
				return false;
		} else if (!payableamount.equals(other.payableamount))
			return false;
		if (priceOfSingleTicket == null) {
			if (other.priceOfSingleTicket != null)
				return false;
		} else if (!priceOfSingleTicket.equals(other.priceOfSingleTicket))
			return false;
		if (promotionCode == null) {
			if (other.promotionCode != null)
				return false;
		} else if (!promotionCode.equals(other.promotionCode))
			return false;
		if (purchaseItems == null) {
			if (other.purchaseItems != null)
				return false;
		} else if (!purchaseItems.equals(other.purchaseItems))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		if (totalamount == null) {
			if (other.totalamount != null)
				return false;
		} else if (!totalamount.equals(other.totalamount))
			return false;
		return true;
	}

}
