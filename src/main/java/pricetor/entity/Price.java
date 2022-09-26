package pricetor.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRICES")
public class Price implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRICE_ID")
	private Long priceId;
	
	@Column(name="BRAND_ID")
	private int brandId;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="PRODUCT_ID")
	private Long productId;
	
	@Column(name="PRIORITY")
	private int priority;
	
	@Column(name="PRICE")
	private float price;
	
	@Column(name="CURR")
	private String curr;

	/**
	 * @return the getPriceId
	 */
	public Long getPriceId() {
		return priceId;
	}

	/**
	 * @param priceId the priceId to set
	 */
	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	/**
	 * @return the brandId
	 */
	public int getBrandId() {
		return brandId;
	}

	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the curr
	 */
	public String getCurr() {
		return curr;
	}

	/**
	 * @param curr the curr to set
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
