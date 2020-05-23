package com.nick.spring.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


// To make war deployment I add "extends SpringBootServletInitializer"
// And override the configure method
//Don't know why, but it's principals I should do stick to, while working
// with this framework I suppose
// Don't wanna check this out, what should be if I just
// add(precisely add, not change) packaging war without making
// changes here
@SpringBootApplication
public class ThymeleafApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ThymeleafApplication.class);
	}

}
