package com.georgiy.denga.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.georgiy.denga")
@Import(value = {DataConfig.class})
//@EnableScheduling
public class ApplicationConfig extends WebMvcConfigurerAdapter {

  @Bean
  public InternalResourceViewResolver setupViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/pages/");
    resolver.setSuffix(".jsp");
    resolver.setViewClass(JstlView.class);
    return resolver;
  }

  @Bean
  public static PropertyPlaceholderConfigurer propertyTestPlaceholderConfigurer() {
    PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
    configurer.setIgnoreResourceNotFound(true);
    return configurer;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
    resourceHandlerRegistry.addResourceHandler("/WEB-INF/pages/**").addResourceLocations("/pages/");
  }
}