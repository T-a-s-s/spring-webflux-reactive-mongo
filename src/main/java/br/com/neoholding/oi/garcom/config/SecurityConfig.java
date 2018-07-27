package br.com.neoholding.oi.garcom.config;

import br.com.neoholding.oi.garcom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig
{

    private UserService userService;

    @Autowired
    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
        return http
                .authorizeExchange()
                .anyExchange().authenticated()
                .and().authenticationManager(reactiveAuthenticationManager())
                .httpBasic().and()
                .build();
    }

    @Bean
    ReactiveAuthenticationManager reactiveAuthenticationManager(){
        return new UserDetailsRepositoryReactiveAuthenticationManager(userService);
    }



}