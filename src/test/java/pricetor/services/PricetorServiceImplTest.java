package pricetor.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.when;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import pricetor.entity.Price;
import pricetor.model.PricingResponseDTO;
import pricetor.repository.IPriceRepository;
import pricetor.run.PortalApplication;

/*
 * Unit Tests
 */
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = PortalApplication.class)
public class PricetorServiceImplTest {

	@InjectMocks
	private PricetorServiceImpl pService;

	@Mock
	private IPriceRepository prepository;

	private Calendar cal = Calendar.getInstance();

	@Test
	@Order(1)
	public void getPriceTest() {

		Price price = new Price();

		Long priceId = (long) 1;
		int brandId = 1;
		cal.set(2020, 06, 14, 00, 00, 00);
		Date startDate = cal.getTime();
		cal.set(2020, 12, 31, 23, 59, 59);
		Date endDate = cal.getTime();
		Long productId = (long) 35455;
		float priceImport = (float) 35.5;

		PricingResponseDTO pricingResponseDtoExpected = new PricingResponseDTO();

		pricingResponseDtoExpected.setBrandId(brandId);
		pricingResponseDtoExpected.setEndDate(endDate);
		pricingResponseDtoExpected.setStartDate(startDate);
		pricingResponseDtoExpected.setPriceId(priceId);
		pricingResponseDtoExpected.setPrice(priceImport);
		pricingResponseDtoExpected.setProductId(productId);

		price.setBrandId(brandId);
		price.setEndDate(endDate);
		price.setStartDate(startDate);
		price.setPriceId(priceId);
		price.setPrice(priceImport);
		price.setProductId(productId);

		cal.set(2020, 06, 14, 10, 00, 00);
		Date applicationDateRequest = cal.getTime();
		Long productIdRequest = (long) 35455;
		int brandIdRequest = 1;

		PricingResponseDTO pricingResponseDto = new PricingResponseDTO();

		when(prepository
				.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
						brandIdRequest, productIdRequest, applicationDateRequest, applicationDateRequest))
								.thenReturn(price);

		try {
			pricingResponseDto = pService.getPrice(applicationDateRequest, productIdRequest, brandIdRequest);
		} catch (Exception e) {
			fail("An exception has occurred getting a price");
		}

		if (pricingResponseDto == null) {
			fail("The method getPrice() must return a pricingResponseDto");
		}

		checkpricingResponseDtoValues(pricingResponseDto, pricingResponseDtoExpected);

	}

	private void checkpricingResponseDtoValues(PricingResponseDTO pricingResponseDTO,
			PricingResponseDTO pricingResponseDTOExpected) {
		assertThat(pricingResponseDTO).hasFieldOrPropertyWithValue("priceId", pricingResponseDTOExpected.getPriceId());
		assertThat(pricingResponseDTO).hasFieldOrPropertyWithValue("brandId", pricingResponseDTOExpected.getBrandId());
		assertThat(pricingResponseDTO).hasFieldOrPropertyWithValue("startDate",
				pricingResponseDTOExpected.getStartDate());
		assertThat(pricingResponseDTO).hasFieldOrPropertyWithValue("endDate", pricingResponseDTOExpected.getEndDate());
		assertThat(pricingResponseDTO).hasFieldOrPropertyWithValue("productId",
				pricingResponseDTOExpected.getProductId());
		assertThat(pricingResponseDTO).hasFieldOrPropertyWithValue("price", pricingResponseDTOExpected.getPrice());
	}
}
