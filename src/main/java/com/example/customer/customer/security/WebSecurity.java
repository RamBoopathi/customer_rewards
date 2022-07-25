package com.example.customer.customer.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	public static final String H2_CONSOLE = "/h2-console/**";
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.POST).permitAll()
		.antMatchers(H2_CONSOLE).permitAll().anyRequest().authenticated();
		
		httpSecurity.headers().frameOptions().disable();
	}

}
