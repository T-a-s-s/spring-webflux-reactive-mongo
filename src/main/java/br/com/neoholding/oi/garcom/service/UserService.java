package br.com.neoholding.oi.garcom.service;

import br.com.neoholding.oi.garcom.model.command.CreateUser;
import br.com.neoholding.oi.garcom.model.dto.UserDTO;
import br.com.neoholding.oi.garcom.model.dto.UserDetailsDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

public interface UserService
{
    Mono<UserDTO> findByName(String name);

    Mono<UserDTO> createUser(@Valid CreateUser createUser);

    Flux<UserDTO> findAllUsers();

    Flux<UserDTO> findAllAdmins();

    Flux<UserDTO> findAllManagers();

    Flux<UserDTO> findAllWaiters();

    Flux<UserDTO> findAllCustomers();

    Flux<UserDTO> findAllKitchens();

    Flux<UserDTO> findAllCups();

    Flux<UserDTO> findAllCards();

    Mono<UserDetailsDTO> findUserDetailsByName(String name);
}
