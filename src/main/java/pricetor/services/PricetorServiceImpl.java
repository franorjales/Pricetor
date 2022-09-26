package pricetor.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import pricetor.commons.Constants;
import pricetor.entity.Price;
import pricetor.exceptions.NoPriceFoundException;
import pricetor.interfaces.IPricetorService;
import pricetor.model.PricingResponseDTO;
import pricetor.repository.IPriceRepository;

public class PricetorServiceImpl implements IPricetorService {

	@Autowired
	private IPriceRepository pRepository;

	public PricingResponseDTO getPrice(Date applicationDate, Long productId, int brandId) throws NoPriceFoundException {

		Price price = this.pRepository
				.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
						brandId, productId, applicationDate, applicationDate);
		if (price == null) {
			throw new NoPriceFoundException(Constants.NO_PRICE_FOUND_EXCEPTION_MESSAGE);
		}
		PricingResponseDTO result = new PricingResponseDTO(price.getPriceId(), price.getBrandId(), price.getStartDate(),
				price.getEndDate(), price.getProductId(), price.getPrice());

		return result;
	}

}
