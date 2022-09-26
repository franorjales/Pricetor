package pricetor.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pricetor.exceptions.NoPriceFoundException;
import pricetor.interfaces.IPricetorService;
import pricetor.interfaces.IPricetorController;
import pricetor.model.PricingResponseDTO;

@RestController
public class PricetorControllerImpl implements IPricetorController {

	private IPricetorService pService;

	@Autowired
	public PricetorControllerImpl(IPricetorService pService) {
		this.pService = pService;
	}

	@Override
	@GetMapping("/pricetor/pricing")
	public PricingResponseDTO getPrice(@RequestParam("applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date applicationDate,
			@RequestParam("productId") Long productId, @RequestParam("brandId")  int brandId)
			throws NoPriceFoundException {

		return this.pService.getPrice(applicationDate, productId, brandId);

	}
}
