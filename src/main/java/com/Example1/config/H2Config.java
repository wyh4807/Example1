package com.Example1.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class H2Config {
	static final String h2WebConsoleUrl = "/H2/*";

    @Bean
    ServletRegistrationBean<WebServlet> h2ServletRegistration() {
		ServletRegistrationBean<WebServlet> registration = new ServletRegistrationBean<WebServlet>(new WebServlet());
        registration.addUrlMappings(h2WebConsoleUrl);
        return registration;
    }
}
