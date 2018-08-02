package br.com.neoholding.oi.garcom.model.mapper;

import br.com.neoholding.oi.garcom.model.command.CreateUser;
import br.com.neoholding.oi.garcom.model.dto.UserDTO;
import br.com.neoholding.oi.garcom.model.dto.UserDetailsDTO;
import br.com.neoholding.oi.garcom.model.entity.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserMapper {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public OiAdmin fromCreateUserToAdmin(CreateUser createUser) {
        return OiAdmin
                .builder()
                .name(createUser.getName().toUpperCase())
                .password(passwordEncoder.encode(createUser.getPassword()))
                .role(createUser.getRole())
                .build();
    }

    public OiManager fromCreateUserToManager(CreateUser createUser) {
        return OiManager
                .builder()
                .name(createUser.getName().toUpperCase())
                .password(passwordEncoder.encode(createUser.getPassword()))
                .role(createUser.getRole())
                .build();
    }

    public Customer fromCreateUserToCustomer(CreateUser createUser) {
        return Customer
                .builder()
                .name(createUser.getName().toUpperCase())
                .password(passwordEncoder.encode(createUser.getPassword()))
                .role(createUser.getRole())
                .build();
    }

    public Waiter fromCreateUserToWaiter(CreateUser createUser) {
        return Waiter
                .builder()
                .name(createUser.getName().toUpperCase())
                .password(passwordEncoder.encode(createUser.getPassword()))
                .role(createUser.getRole())
                .build();
    }

    public Kitchen fromCreateUserToKitchen(CreateUser createUser) {
        return Kitchen
                .builder()
                .name(createUser.getName().toUpperCase())
                .password(passwordEncoder.encode(createUser.getPassword()))
                .role(createUser.getRole())
                .build();
    }

    public Cup fromCreateUserToCup(CreateUser createUser) {
        return Cup
                .builder()
                .name(createUser.getName().toUpperCase())
                .password(passwordEncoder.encode(createUser.getPassword()))
                .role(createUser.getRole())
                .build();
    }

    public Card fromCreateUserToCard(CreateUser createUser) {
        return Card
                .builder()
                .name(createUser.getName().toUpperCase())
                .password(passwordEncoder.encode(createUser.getPassword()))
                .role(createUser.getRole())
                .build();
    }

    public UserDTO fromAdminToDTO(OiAdmin oiAdmin) {
        return UserDTO
                .builder()
                .name(oiAdmin.getName())
                .role(oiAdmin.getRole())
                .build();
    }

    public UserDTO fromManagerToDTO(OiManager oiManager) {
        return UserDTO
                .builder()
                .name(oiManager.getName())
                .role(oiManager.getRole())
                .build();
    }

    public UserDTO fromCustomerToDTO(Customer customer) {
        return UserDTO
                .builder()
                .name(customer.getName())
                .role(customer.getRole())
                .build();
    }

    public UserDTO fromKitchenToDTO(Kitchen kitchen) {
        return UserDTO
                .builder()
                .name(kitchen.getName())
                .role(kitchen.getRole())
                .build();
    }

    public UserDTO fromCupToDTO(Cup cup) {
        return UserDTO
                .builder()
                .name(cup.getName())
                .role(cup.getRole())
                .build();
    }

    public UserDTO fromCardToDTO(Card card) {
        return UserDTO
                .builder()
                .name(card.getName())
                .role(card.getRole())
                .build();
    }

    public UserDTO fromWaiterToDTO(Waiter waiter) {
        return UserDTO
                .builder()
                .name(waiter.getName())
                .role(waiter.getRole())
                .build();
    }

    public UserDetailsDTO fromAdminToUserDetailsDTO(OiAdmin oiAdmin) {
        return UserDetailsDTO
                .builder()
                .name(oiAdmin.getName())
                .password(oiAdmin.getPassword())
                .role(oiAdmin.getRole())
                .build();

    }

    public UserDetailsDTO fromManagerToUserDetailsDTO(OiManager oiManager) {
        return UserDetailsDTO
                .builder()
                .name(oiManager.getName())
                .password(oiManager.getPassword())
                .role(oiManager.getRole())
                .build();
    }

    public UserDetailsDTO fromWaiterToUserDetailsDTO(Waiter waiter) {
        return UserDetailsDTO
                .builder()
                .name(waiter.getName())
                .password(waiter.getPassword())
                .role(waiter.getRole())
                .build();
    }

    public UserDetailsDTO fromKitchenToUserDetailsDTO(Kitchen kitchen) {
        return UserDetailsDTO
                .builder()
                .name(kitchen.getName())
                .password(kitchen.getPassword())
                .role(kitchen.getRole())
                .build();
    }

    public UserDetailsDTO fromCustomerToUserDetailsDTO(Customer customer) {
        return UserDetailsDTO
                .builder()
                .name(customer.getName())
                .password(customer.getPassword())
                .role(customer.getRole())
                .build();
    }

    public UserDetailsDTO fromCupToUserDetailsDTO(Cup cup) {
        return UserDetailsDTO
                .builder()
                .name(cup.getName())
                .password(cup.getPassword())
                .role(cup.getRole())
                .build();
    }

    public UserDetailsDTO fromCardToUserDetailsDTO(Card card) {
        return UserDetailsDTO
                .builder()
                .name(card.getName())
                .password(card.getPassword())
                .role(card.getRole())
                .build();
    }

    public Mono<UserDTO> fromAdminMonoToDtoMono(Mono<OiAdmin> oiAdminMono) {
        return oiAdminMono.map(this::fromAdminToDTO);
    }

    public Mono<UserDTO> fromManagerMonoToDtoMono(Mono<OiManager> oiManagerMono) {
        return oiManagerMono.map(this::fromManagerToDTO);
    }

    public Mono<UserDTO> fromCustomerMonoToDtoMono(Mono<Customer> customerMono) {
        return customerMono.map(this::fromCustomerToDTO);
    }

    public Mono<UserDTO> fromWaiterMonoToDtoMono(Mono<Waiter> waiterMono) {
        return waiterMono.map(this::fromWaiterToDTO);
    }

    public Mono<UserDTO> fromKitchenMonoToDtoMono(Mono<Kitchen> kitchenMono) {
        return kitchenMono.map(this::fromKitchenToDTO);
    }

    public Mono<UserDTO> fromCupMonoToDtoMono(Mono<Cup> cupMono) {
        return cupMono.map(this::fromCupToDTO);
    }

    public Mono<UserDTO> fromCardMonoToDtoMono(Mono<Card> cardMono) {
        return cardMono.map(this::fromCardToDTO);
    }

}
