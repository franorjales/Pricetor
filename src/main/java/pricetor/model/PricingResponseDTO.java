package pricetor.model;

import java.util.Date;

public class PricingResponseDTO {

	private Long priceId;
	private int brandId;
	private Date startDate;
	private Date endDate;
	private Long productId;
	private float price;
	
	public PricingResponseDTO() {}
	
	public PricingResponseDTO(Long priceId, int brandId, Date startDate, Date endDate, Long productId, float price) {
		this.priceId = priceId;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.productId = productId;
		this.price = price;
	}

	/**
	 * @return the priceId
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
	
	
	
}
