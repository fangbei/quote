package com.gildata.quote.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .csrf().disable()
			.authorizeRequests()
				.antMatchers("/assets/**").permitAll()
				.anyRequest().authenticated()
				.and()			
			.logout()
				.logoutSuccessUrl("/login.html?logout")
				.logoutUrl("/logout.html")
				.permitAll()
				.and()
			.formLogin()
			    .loginPage("/login.html")
				.defaultSuccessUrl("/index.html",true)
				.failureUrl("/login.html?error")
				.permitAll();
//				.and()
//			.rememberMe();
	}

	@Override
	protected void registerAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("test").password("test").roles("USER").and()
				.withUser("admin").password("admin").roles("ADMIN","USER");
	}
}