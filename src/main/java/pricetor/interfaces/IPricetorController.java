package pricetor.interfaces;

import java.util.Date;
import pricetor.exceptions.NoPriceFoundException;
import pricetor.model.PricingResponseDTO;

public interface IPricetorController {

	public PricingResponseDTO getPrice(Date applicationDate, Long productId, int brandId) throws NoPriceFoundException;

}
