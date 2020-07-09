package com.classicpkj.spring.security.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("classicprasanna").password("password01").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("gopinath").password("jena").roles("USER");
	}
	
	
	// security for all API means for all controller its basic
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http.csrf().disable();
	 * http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	 * 
	 * }
	 */

	// security based on URL
	/*
	 * protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and().
	 * httpBasic();
	 * 
	 * }
	 */

	// security based on Role
	
	  protected void configure(HttpSecurity http) throws Exception {
	  http.csrf().disable();
	  http.authorizeRequests().antMatchers("/rest/**").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();
	  }
	

	@Bean
	public static NoOpPasswordEncoder paswordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();

	}

}
