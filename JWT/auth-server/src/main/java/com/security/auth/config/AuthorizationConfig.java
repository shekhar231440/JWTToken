package com.security.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.security.auth.service.UserService;

@Configuration
public class AuthorizationConfig extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	    private UserService userService;

	    @Autowired
//	    private JWTFilter jwtFilter;

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	        auth.userDetailsService(userService);
	    }

		
		  @Override
		  @Bean 
		  public AuthenticationManager authenticationManagerBean() throws
		  Exception { return super.authenticationManagerBean(); }
		 

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf()
	                .disable()
	                .authorizeRequests()
	                .antMatchers("/**")
	                .permitAll()
	                .and()
	                .sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	     //   http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	    }

}
