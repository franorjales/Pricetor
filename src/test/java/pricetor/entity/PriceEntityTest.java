package pricetor.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pricetor.repository.IPriceRepository;
import pricetor.run.PortalApplication;

/*
 * Unit Tests
 */
@SpringBootTest(classes = PortalApplication.class)
public class PriceEntityTest {

	@Autowired
	private IPriceRepository repository;

	private Calendar cal = Calendar.getInstance();

	@Test
	@Order(1)
	public void getPriceTestFirstCase() {

		int brandIdRequest = 1;
		Long productIdRequest = (long) 35455;
		cal.set(2020, 05, 14, 10, 00, 00);
		Date dateRequest = cal.getTime();

		Long priceId = (long) 1;
		int brandId = 1;
		cal.set(2020, 05, 14, 00, 00, 00);
		Date startDate = cal.getTime();
		cal.set(2020, 11, 31, 23, 59, 59);
		Date endDate = cal.getTime();
		Long productId = (long) 35455;
		int priority = 0;
		float priceImport = (float) 35.5;
		String curr = "EUR";

		Price priceExpected = new Price();
		priceExpected.setBrandId(brandId);
		priceExpected.setCurr(curr);
		priceExpected.setEndDate(endDate);
		priceExpected.setStartDate(startDate);
		priceExpected.setPriceId(priceId);
		priceExpected.setPriority(priority);
		priceExpected.setPrice(priceImport);
		priceExpected.setProductId(productId);

		Price price = repository
				.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
						brandIdRequest, productIdRequest, dateRequest, dateRequest);

		checkPriceValues(price, priceExpected);

	}
	
	@Test
	@Order(2)
	public void getPriceTestSecondCase() {

		int brandIdRequest = 1;
		Long productIdRequest = (long) 35455;
		cal.set(2020, 05, 14, 16, 00, 00);
		Date dateRequest = cal.getTime();

		Long priceId = (long) 2;
		int brandId = 1;
		cal.set(2020, 05, 14, 15, 00, 00);
		Date startDate = cal.getTime();
		cal.set(2020, 05, 14, 18, 30, 00);
		Date endDate = cal.getTime();
		Long productId = (long) 35455;
		int priority = 1;
		float priceImport = (float) 25.45;
		String curr = "EUR";

		Price priceExpected = new Price();
		priceExpected.setBrandId(brandId);
		priceExpected.setCurr(curr);
		priceExpected.setEndDate(endDate);
		priceExpected.setStartDate(startDate);
		priceExpected.setPriceId(priceId);
		priceExpected.setPriority(priority);
		priceExpected.setPrice(priceImport);
		priceExpected.setProductId(productId);

		Price price = repository
				.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
						brandIdRequest, productIdRequest, dateRequest, dateRequest);

		checkPriceValues(price, priceExpected);

	}
	
	@Test
	@Order(3)
	public void getPriceTestThirdCase() {

		int brandIdRequest = 1;
		Long productIdRequest = (long) 35455;
		cal.set(2020, 05, 14, 21, 00, 00);
		Date dateRequest = cal.getTime();

		Long priceId = (long) 1;
		int brandId = 1;
		cal.set(2020, 05, 14, 00, 00, 00);
		Date startDate = cal.getTime();
		cal.set(2020, 11, 31, 23, 59, 59);
		Date endDate = cal.getTime();
		Long productId = (long) 35455;
		int priority = 0;
		float priceImport = (float) 35.5;
		String curr = "EUR";

		Price priceExpected = new Price();
		priceExpected.setBrandId(brandId);
		priceExpected.setCurr(curr);
		priceExpected.setEndDate(endDate);
		priceExpected.setStartDate(startDate);
		priceExpected.setPriceId(priceId);
		priceExpected.setPriority(priority);
		priceExpected.setPrice(priceImport);
		priceExpected.setProductId(productId);

		Price price = repository
				.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
						brandIdRequest, productIdRequest, dateRequest, dateRequest);

		checkPriceValues(price, priceExpected);

	}
	
	@Test
	@Order(4)
	public void getPriceTestFourthCase() {

		int brandIdRequest = 1;
		Long productIdRequest = (long) 35455;
		cal.set(2020, 05, 15, 10, 00, 00);
		Date dateRequest = cal.getTime();

		Long priceId = (long) 3;
		int brandId = 1;
		cal.set(2020, 05, 15, 00, 00, 00);
		Date startDate = cal.getTime();
		cal.set(2020, 05, 15, 11, 00, 00);
		Date endDate = cal.getTime();
		Long productId = (long) 35455;
		int priority = 1;
		float priceImport = (float) 30.5;
		String curr = "EUR";

		Price priceExpected = new Price();
		priceExpected.setBrandId(brandId);
		priceExpected.setCurr(curr);
		priceExpected.setEndDate(endDate);
		priceExpected.setStartDate(startDate);
		priceExpected.setPriceId(priceId);
		priceExpected.setPriority(priority);
		priceExpected.setPrice(priceImport);
		priceExpected.setProductId(productId);

		Price price = repository
				.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
						brandIdRequest, productIdRequest, dateRequest, dateRequest);

		checkPriceValues(price, priceExpected);

	}
	
	@Test
	@Order(5)
	public void getPriceTestFifthCase() {

		int brandIdRequest = 1;
		Long productIdRequest = (long) 35455;
		cal.set(2020, 05, 16, 21, 00, 00);
		Date dateRequest = cal.getTime();

		Long priceId = (long) 4;
		int brandId = 1;
		cal.set(2020, 05, 15, 16, 00, 00);
		Date startDate = cal.getTime();
		cal.set(2020, 11, 31, 23, 59, 59);
		Date endDate = cal.getTime();
		Long productId = (long) 35455;
		int priority = 1;
		float priceImport = (float) 38.95;
		String curr = "EUR";

		Price priceExpected = new Price();
		priceExpected.setBrandId(brandId);
		priceExpected.setCurr(curr);
		priceExpected.setEndDate(endDate);
		priceExpected.setStartDate(startDate);
		priceExpected.setPriceId(priceId);
		priceExpected.setPriority(priority);
		priceExpected.setPrice(priceImport);
		priceExpected.setProductId(productId);

		Price price = repository
				.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
						brandIdRequest, productIdRequest, dateRequest, dateRequest);

		checkPriceValues(price, priceExpected);

	}

	private void checkPriceValues(Price price, Price priceExpected) {
		
		Timestamp tsStartDate=new Timestamp(priceExpected.getStartDate().toInstant().truncatedTo( ChronoUnit.SECONDS )
			       .toEpochMilli() );  
		Timestamp tsEndDate=new Timestamp(priceExpected.getEndDate().toInstant().truncatedTo( ChronoUnit.SECONDS )
			       .toEpochMilli() );  

		assertEquals(tsStartDate.getTime(), price.getStartDate().getTime());
		assertEquals(tsEndDate.getTime(), price.getEndDate().getTime());

		assertThat(price).hasFieldOrPropertyWithValue("priceId", priceExpected.getPriceId());
		assertThat(price).hasFieldOrPropertyWithValue("brandId", priceExpected.getBrandId());
		assertThat(price).hasFieldOrPropertyWithValue("productId", priceExpected.getProductId());
		assertThat(price).hasFieldOrPropertyWithValue("priority", priceExpected.getPriority());
		assertThat(price).hasFieldOrPropertyWithValue("price", priceExpected.getPrice());
		assertThat(price).hasFieldOrPropertyWithValue("curr", priceExpected.getCurr());
	}

}
