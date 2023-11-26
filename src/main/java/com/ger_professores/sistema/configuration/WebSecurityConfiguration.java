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
        .and()
        .authorizeHttpRequests()
        .requestMatchers("/api/**")
        .authenticated()
        .and()
        .authorizeHttpRequests()
        .requestMatchers("/api/**")
        .hasAnyAuthority("ADMIN")
        .requestMatchers("/api/admin")
        .hasAnyAuthority("ADMIN")
        .requestMatchers("/api/coordenador")
        .hasAnyAuthority("COORDENADOR")
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
