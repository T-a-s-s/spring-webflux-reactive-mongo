package br.com.neoholding.oi.garcom.service;

import br.com.neoholding.oi.garcom.model.command.CreateUser;
import br.com.neoholding.oi.garcom.model.command.DeleteUser;
import br.com.neoholding.oi.garcom.model.command.PatchUser;
import br.com.neoholding.oi.garcom.model.dto.UserDTO;
import br.com.neoholding.oi.garcom.model.dto.UserDetailsDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    Flux<UserDTO> deleteByName(DeleteUser deleteUser);

    Mono<UserDTO> patchUser(@NotNull @NotEmpty String name, @NotNull @NotEmpty PatchUser patchUser);
}
