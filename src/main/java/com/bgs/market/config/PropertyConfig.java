package com.bgs.market.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class PropertyConfig {

    /**
     * The Message Resource is activated to use the messages through a properties and not within the code. For Hibernate Validator
     */
    @Bean(name = "validationMessageSource")
    public ResourceBundleMessageSource validationMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("validationMessages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setCacheSeconds(0);
        return messageSource;
    }

}
