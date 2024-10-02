package com.minedu.project.maintenance_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/v1/index2").permitAll()
                    .anyRequest().authenticated()
                )
                .formLogin(login -> login
                	.successHandler(successHandler())
                    .permitAll()
                    .defaultSuccessUrl("/v1/Inicio", true)
                )
                .sessionManagement(session -> session
                		.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .build();
    }
	
	public AuthenticationSuccessHandler successHandler() {
		return ((request, response, authentication) -> {
			response.sendRedirect(request.getContextPath() + "/v1/Inicio");
		});
	}
}

