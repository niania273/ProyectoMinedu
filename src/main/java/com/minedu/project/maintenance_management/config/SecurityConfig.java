package com.minedu.project.maintenance_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(auth -> auth
			    .requestMatchers("/").permitAll()
			    .requestMatchers("/register").permitAll()
			    .requestMatchers("/login").permitAll()
			    .requestMatchers("/logout").permitAll()
			    .anyRequest().authenticated()
				)
				.formLogin(form -> form
						.defaultSuccessUrl("/inicio", true)
				)
				.logout(config -> config.logoutSuccessUrl("/"))
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
