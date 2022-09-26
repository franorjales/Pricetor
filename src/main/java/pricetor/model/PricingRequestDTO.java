package pricetor.model;

import java.util.Date;

public class PricingRequestDTO {

	Date applicationDate;
	String productId;
	String brandId;
	
	public PricingRequestDTO(Date applicationDate, String productId, String brandId) {
		super();
		this.applicationDate = applicationDate;
		this.productId = productId;
		this.brandId = brandId;
	}
	
	/**
	 * @return the applicationDate
	 */
	public Date getApplicationDate() {
		return applicationDate;
	}
	/**
	 * @param applicationDate the applicationDate to set
	 */
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * @return the brandId
	 */
	public String getBrandId() {
		return brandId;
	}
	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	
	

}
