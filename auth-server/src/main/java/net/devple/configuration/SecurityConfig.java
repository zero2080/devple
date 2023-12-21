package net.devple.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain configure(HttpSecurity secure) throws Exception{
    return secure
        .authorizeHttpRequests(http->{
          http.anyRequest().permitAll();
        })
        .build();
  }
}
