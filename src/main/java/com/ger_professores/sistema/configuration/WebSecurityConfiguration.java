package com.ger_professores.sistema.configuration;

import com.ger_professores.sistema.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration {

  @Autowired
  private JwtRequestFilter requestFilter;

  @Configuration
  public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
      throws Exception {
      return http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers("/authenticate", "/sign-up")
        .permitAll()
        .requestMatchers(
          "/api/v1/auth/**",
          "/v2/api-docs",
          "/v3/api-docs",
          "/v3/api-docs/**",
          "/swagger-resources",
          "/swagger-resources/**",
          "/configuration/ui",
          "/configuration/security",
          "/swagger-ui/**",
          "/webjars/**",
          "/swagger-ui.html"
        )
        .permitAll() // Added permission for swagger-ui
        .and()
        .authorizeHttpRequests() // Changed to use hasAnyRole instead of hasAnyAuthority
        .requestMatchers("/api/admin/**")
        .hasAnyRole("ADMIN")
        .requestMatchers("/api/coordenador")
        .hasAnyRole("COORDENADOR")
        .anyRequest()
        .authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilterBefore(
          requestFilter,
          UsernamePasswordAuthenticationFilter.class
        )
        .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
      AuthenticationConfiguration config
    ) throws Exception {
      return config.getAuthenticationManager();
    }
  }
}
