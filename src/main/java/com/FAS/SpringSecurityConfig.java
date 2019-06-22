package com.FAS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.FAS.service.impl.BuisnessOwnerServiceImpl;
import com.FAS.service.impl.ConsumerServiceImpl;
import com.FAS.service.impl.SellerServiceImpl;

@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ConsumerServiceImpl consumerService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(consumerService).passwordEncoder(passwordEncoder);

	}
	
	@Configuration
	@Order(1)
	public static class BuisnessOwnerConfigurationAdapter extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private BCryptPasswordEncoder passwordEncoder;
		
		@Autowired
		private BuisnessOwnerServiceImpl buisnessOwnerServiceImpl;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
		}
		
		@Autowired
		public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
			build.userDetailsService(buisnessOwnerServiceImpl).passwordEncoder(passwordEncoder);
			}
	}
	
	@Configuration
	@Order(2)
	public static class SellerConfigurationAdapter extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private BCryptPasswordEncoder passwordEncoder;
		
		@Autowired
		private SellerServiceImpl sellerServiceImpl;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {

		}
		
		@Autowired
		public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
			build.userDetailsService(sellerServiceImpl).passwordEncoder(passwordEncoder);
			}
	}
}