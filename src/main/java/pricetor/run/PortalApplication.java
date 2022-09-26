package pricetor.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"pricetor"})
@ComponentScan(basePackages={"pricetor"}) 
@EntityScan(basePackages={"pricetor"}) 
@EnableJpaRepositories(basePackages={"pricetor"}) 
public class PortalApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PortalApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }
}