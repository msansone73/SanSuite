package br.com.msansone.sanlogin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .anyRequest().authenticated()
            ).cors().disable()
            .csrf().disable()
            .httpBasic();
        return http.build();
    }
    
    
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
    	
    	String senhaAberta="batata";
    	
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password(senhaAberta)
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
    
  

}