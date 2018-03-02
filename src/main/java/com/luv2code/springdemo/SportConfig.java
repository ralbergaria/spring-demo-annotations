package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
//@ComponentScan("com.luv2code.springdemo")
public class SportConfig {
	
	 // add support to resolve ${...} properties this is for spring 4.2 our lower.
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer
//                    propertySourcesPlaceHolderConfigurer() {
//        
//        return new PropertySourcesPlaceholderConfigurer();
//    }
	
	// define bean for sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
