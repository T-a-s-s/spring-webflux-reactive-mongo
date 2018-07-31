package br.com.neoholding.oi.garcom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig
{
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http)
    {
        return http
                .authorizeExchange()
                .pathMatchers("/**").authenticated()
                .and().httpBasic()
                .and().formLogin().disable().csrf().disable().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    @Autowired
//    @Qualifier("reactiveUserDetailsServiceImpl")
//    public ReactiveUserDetailsService reactiveUserDetailsService(ReactiveUserDetailsService reactiveUserDetailsServiceImpl)
//    {
//        return reactiveUserDetailsServiceImpl;
//    }

    @Bean
    ReactiveUserDetailsService userDetailService(PasswordEncoder encoder) {
        User.UserBuilder user = User.withUsername("tass")
                .authorities(new SimpleGrantedAuthority("ROLE_ADMIN"))
                .password(encoder.encode("skatalites"));

        return new MapReactiveUserDetailsService(user.build());
    }


//    @Bean
//    public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
//        return http.authorizeExchange()
//                .anyExchange().authenticated()
//                .and().build();
//    }

//    @Bean
//    public MapReactiveUserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new MapReactiveUserDetailsService(user);
//
//@Bean
//public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http)
//{
//        return http
//                .authorizeExchange()
//                .anyExchange()
//                .permitAll()
//                .and()
//                .csrf().disable()
//                .build();
//}


}