package pricetor.api;

import static org.assertj.core.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pricetor.model.PricingResponseDTO;
import pricetor.run.PortalApplication;

/*
 * Integration Tests
 */
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = PortalApplication.class)
@AutoConfigureMockMvc
public class PricetorControllerImplTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private PricetorControllerImpl gController;

	private Calendar cal = Calendar.getInstance();

	@BeforeEach
	public void setup() {
		this.mvc = MockMvcBuilders.standaloneSetup(gController).build();
	}

	@Test
	@Order(1)
	public void getPriceWithPriceIdOneTest() {

		PricingResponseDTO pricingResponseDTOExpected = new PricingResponseDTO();

		Long priceId = (long) 1;
		int brandId = 1;
		cal.set(2020, 05, 14, 00, 00, 00);
		Date startDate = cal.getTime();
		cal.set(2020, 11, 31, 23, 59, 59);
		Date endDate = cal.getTime();
		Long productId = (long) 35455;
		float priceImport = (float) 35.5;

		pricingResponseDTOExpected.setBrandId(brandId);
		pricingResponseDTOExpected.setEndDate(endDate);
		pricingResponseDTOExpected.setStartDate(startDate);
		pricingResponseDTOExpected.setPriceId(priceId);
		pricingResponseDTOExpected.setPrice(priceImport);
		pricingResponseDTOExpected.setProductId(productId);

		Long productIdExpected = (long) 35455;
		int brandIdExpected = 1;
		
		try {
			mvc.perform(get("/pricetor/pricing").param("applicationDate", "2020-06-14 10:00:00")
					.param("productId", productIdExpected.toString())
					.param("brandId", Integer.toString(brandIdExpected))).andDo(print()).andExpect(status().isOk())
					.andExpect(jsonPath("$.priceId").value(pricingResponseDTOExpected.getPriceId().toString()))
					.andExpect(jsonPath("$.brandId").value(Integer.toString(pricingResponseDTOExpected.getBrandId())))
					.andExpect(jsonPath("$.startDate").value(pricingResponseDTOExpected.getStartDate().toInstant().truncatedTo( ChronoUnit.SECONDS )
						       .toEpochMilli()))
					.andExpect(jsonPath("$.endDate").value(pricingResponseDTOExpected.getEndDate().toInstant().truncatedTo( ChronoUnit.SECONDS )
						       .toEpochMilli()))
					.andExpect(jsonPath("$.productId").value(pricingResponseDTOExpected.getProductId().toString()))
					.andExpect(jsonPath("$.price").value(Float.toString(pricingResponseDTOExpected.getPrice())));

		} catch (Exception e) {
			fail("There has been an Exception sending the request");
		}

	}

}
