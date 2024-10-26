package com.minedu.project.maintenance_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(auth -> auth
			    .requestMatchers("/").permitAll()
			    .requestMatchers("/register").permitAll()
			    .requestMatchers("/custom-login").permitAll()
			    .requestMatchers("/logout").permitAll()
			    .requestMatchers("/solicitudes/editar").hasAuthority("USAU")
			    .requestMatchers("/solicitudes/eliminar").hasAuthority("USAU")
			    .requestMatchers("/suministradores/registrar").hasAuthority("LOG")
			    .requestMatchers("/suministradores/editar").hasAuthority("LOG")
			    .requestMatchers("/suministradores/eliminar").hasAuthority("LOG")
			    .requestMatchers("/requerimientos/generar").hasAuthority("USAU")
			    .requestMatchers("/requerimientos/actualizar").hasAuthority("USAU")
			    .requestMatchers("/requerimientos/eliminar").hasAuthority("USAU")
			    .anyRequest().authenticated()
				)
				.formLogin(form -> form
						.loginPage("/custom-login")
						.defaultSuccessUrl("/inicio", true)
				)
				.logout(config -> config
						.logoutUrl("/logout")
						.logoutSuccessUrl("/ingreso")
				)
				.build();
	}

    @Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
