package pricetor.repository;

import java.util.Date;
import org.springframework.data.repository.CrudRepository;
import pricetor.entity.Price;

public interface IPriceRepository extends CrudRepository<Price, Long>{
	
	Price findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(int brandId,Long productId,Date startDate,Date endDate);
	
}
