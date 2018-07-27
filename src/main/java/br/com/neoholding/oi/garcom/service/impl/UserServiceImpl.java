package br.com.neoholding.oi.garcom.service.impl;

import br.com.neoholding.oi.garcom.repository.UserRepository;
import br.com.neoholding.oi.garcom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository userRepository;

    @Override
    public Mono<UserDetails> findByUsername(String name) {
        return userRepository.findByName(name)
                .map(oiUser -> {
                    return new User(oiUser.getName(), oiUser.getPassword(), getAuthority());
                });
    }

    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
