package br.com.neoholding.oi.garcom.service.impl;

import br.com.neoholding.oi.garcom.enumeration.OiRole;
import br.com.neoholding.oi.garcom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

//@Service("reactiveUserDetailsServiceImpl")
public class ReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService
{
    @Autowired
    UserService userService;

    @Override
    public Mono<UserDetails> findByUsername(String name)
    {
        return userService.findUserDetailsByName(name)
                .map(userDetailsDTO -> {
                    return new User(userDetailsDTO.getName(), userDetailsDTO.getPassword(), getAuthority(userDetailsDTO.getRole()));
                });
    }

    private List getAuthority(OiRole role)
    {
        switch (role) {
            case ADMIN:
                return Arrays.asList(new SimpleGrantedAuthority(role.getRoleName()));
            case MANAGER:
                return Arrays.asList(new SimpleGrantedAuthority(role.getRoleName()));
            case CUSTOMER:
                return Arrays.asList(new SimpleGrantedAuthority(role.getRoleName()));
            case WAITER:
                return Arrays.asList(new SimpleGrantedAuthority(role.getRoleName()));
            case KITCHEN:
                return Arrays.asList(new SimpleGrantedAuthority(role.getRoleName()));
            case CUP:
                return Arrays.asList(new SimpleGrantedAuthority(role.getRoleName()));
            case CARD:
                return Arrays.asList(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return Arrays.asList(new SimpleGrantedAuthority("ANONYMOUS"));
    }
}
