package pricetor.interfaces;

import java.util.Date;
import pricetor.exceptions.NoPriceFoundException;
import pricetor.model.PricingResponseDTO;

public interface IPricetorService {
	public PricingResponseDTO getPrice(Date applicationDate, Long productId, int brandId) throws NoPriceFoundException;
}
