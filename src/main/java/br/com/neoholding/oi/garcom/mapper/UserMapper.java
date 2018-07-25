package br.com.neoholding.oi.garcom.mapper;

import br.com.neoholding.oi.garcom.model.command.CreateUser;
import br.com.neoholding.oi.garcom.model.dto.UserDTO;
import br.com.neoholding.oi.garcom.model.entity.user.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserMapper {

    public Mono<UserDTO> fromUserToDTO(Mono<OiUser> user) {
        return user.map(oiUser -> {
            return UserDTO
                    .builder()
                    .name(oiUser.getName())
                    .role(oiUser.getRole())
                    .build();
        });
    }

    public OiAdmin fromCreateUserToAdmin(CreateUser createUser) {
        return OiAdmin
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .build();
    }

    public OiManager fromCreateUserToManager(CreateUser createUser) {
        return OiManager
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .build();
    }

    public Customer fromCreateUserToCustomer(CreateUser createUser) {
        return Customer
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .build();
    }

    public Waiter fromCreateUserToWaiter(CreateUser createUser) {
        return Waiter
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .build();
    }

    public Kitchen fromCreateUserToKitchen(CreateUser createUser) {
        return Kitchen
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .build();
    }

    public Cup fromCreateUserToCup(CreateUser createUser) {
        return Cup
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .build();
    }

    public Card fromCreateUserToCard(CreateUser createUser) {
        return Card
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .build();
    }

    public Mono<UserDTO> fromAdminToDTO(Mono<OiAdmin> oiAdminMono) {
        return oiAdminMono.map(oiAdmin -> {
                return UserDTO
                        .builder()
                        .name(oiAdmin.getName())
                        .role(oiAdmin.getRole())
                        .build();
        });
    }

    public Mono<UserDTO> fromManagerToDTO(Mono<OiManager> oiManagerMono) {
        return oiManagerMono.map(oiManager -> {
            return UserDTO
                    .builder()
                    .name(oiManager.getName())
                    .role(oiManager.getRole())
                    .build();
        });
    }

    public Mono<UserDTO> fromCustomerToDTO(Mono<Customer> customerMono) {
        return customerMono.map(customer -> {
            return UserDTO
                    .builder()
                    .name(customer.getName())
                    .role(customer.getRole())
                    .build();
        });
    }

    public Mono<UserDTO> fromWaiterToDTO(Mono<Waiter> waiterMono) {
        return waiterMono.map(waiter -> {
            return UserDTO
                    .builder()
                    .name(waiter.getName())
                    .role(waiter.getRole())
                    .build();
        });
    }

    public Mono<UserDTO> fromKitchenToDTO(Mono<Kitchen> kitchenMono) {
        return kitchenMono.map(kitchen -> {
            return UserDTO
                    .builder()
                    .name(kitchen.getName())
                    .role(kitchen.getRole())
                    .build();
        });
    }

    public Mono<UserDTO> fromCupToDTO(Mono<Cup> cupMono) {
        return cupMono.map(cup -> {
            return UserDTO
                    .builder()
                    .name(cup.getName())
                    .role(cup.getRole())
                    .build();
        });
    }

    public Mono<UserDTO> fromCardToDTO(Mono<Card> cardMono) {
        return cardMono.map(card -> {
            return UserDTO
                    .builder()
                    .name(card.getName())
                    .role(card.getRole())
                    .build();
        });
    }
}
