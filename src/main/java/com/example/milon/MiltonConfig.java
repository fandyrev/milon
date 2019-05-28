package com.example.milon;

import io.milton.servlet.SpringMiltonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class MiltonConfig {

    @Bean
    FilterRegistrationBean filterRegistrationBean()
    {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(springMiltonFilter());
        bean.addInitParameter("milton.exclude.paths", "c:/tmp");
        bean.addInitParameter("resource.factory.class", "io.milton.http.annotated.AnnotationResourceFactory");
        bean.addInitParameter("controllerPackagesToScan", "com.damnhandy.spring.milton");
        bean.addUrlPatterns("/*");
        return bean;
    }

    @Bean
    SpringMiltonFilter springMiltonFilter()
    {
        return new SpringMiltonFilter();
    }
}
