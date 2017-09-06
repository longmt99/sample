package com.saas;

import javax.annotation.PostConstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.saas.config.SwaggerConfig;


/**
 * @longmt99
 */
@SpringBootApplication
@EnableConfigurationProperties
@MapperScan(basePackages = "com.saas.mapping")
@ComponentScan(basePackages = "com.saas.service.impl,com.saas.controller")
@Import(SwaggerConfig.class)
public class StudentRestAPI extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(StudentRestAPI.class);
	
	@Value("${spring.datasource.url}")
	String datasource;
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StudentRestAPI.class);
    }
    @PostConstruct
	public void init() {
		log.info("RUN datasource : " + datasource);
		System.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
	}
    public static void main(String[] args) {
    	System.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
        SpringApplication.run(StudentRestAPI.class, args);
    }
}