package pricetor.run;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import pricetor.interfaces.IPricetorService;
import pricetor.services.PricetorServiceImpl;

@Configuration
public class PortalConfiguration {
  
    @Bean
    public IPricetorService pService() {
        return new PricetorServiceImpl();
    }
	
}
