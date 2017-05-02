package com.kpg.diary.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.boot.annotation.EnableVaadinServlet;

/**
 * The Class DiaryApplication.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = { "com.kpg.diary.model" })
@EnableJpaRepositories(basePackages = { "com.kpg.diary.dao" })
@ComponentScan(basePackages = { "com.kpg.diary" })
@EnableVaadin
@EnableVaadinServlet
public class DiaryApplication extends SpringBootServletInitializer {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
	SpringApplication.run(DiaryApplication.class, args);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.boot.web.support.SpringBootServletInitializer#
     * configure(org.springframework.boot.builder.SpringApplicationBuilder)
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	return builder.sources(DiaryApplication.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
	
	//servletContext.getse
	// TODO Auto-generated method stub
	super.onStartup(servletContext);
    }

}
