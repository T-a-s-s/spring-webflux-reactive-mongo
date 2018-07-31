package br.com.neoholding.oi.garcom.service.impl;

import br.com.neoholding.oi.garcom.exception.OiRoleNotFoundException;
import br.com.neoholding.oi.garcom.mapper.UserMapper;
import br.com.neoholding.oi.garcom.model.command.CreateUser;
import br.com.neoholding.oi.garcom.model.dto.UserDTO;
import br.com.neoholding.oi.garcom.model.dto.UserDetailsDTO;
import br.com.neoholding.oi.garcom.repository.*;
import br.com.neoholding.oi.garcom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
public class UserServiceImpl implements UserService
{
    AdminRepository adminRepository;
    ManagerRepository managerRepository;
    CustomerRepository customerRepository;
    WaiterRepository waiterRepository;
    KitchenRepository kitchenRepository;
    CupRepository cupRepository;
    CardRepository cardRepository;
    UserMapper userMapper;

    @Autowired
    public UserServiceImpl(AdminRepository adminRepository,
                           ManagerRepository managerRepository,
                           CustomerRepository customerRepository,
                           WaiterRepository waiterRepository,
                           KitchenRepository kitchenRepository,
                           CupRepository cupRepository,
                           CardRepository cardRepository,
                           UserMapper userMapper)
    {
        this.adminRepository = adminRepository;
        this.managerRepository = managerRepository;
        this.customerRepository = customerRepository;
        this.waiterRepository = waiterRepository;
        this.kitchenRepository = kitchenRepository;
        this.cupRepository = cupRepository;
        this.cardRepository = cardRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Mono<UserDetailsDTO> findUserDetailsByName(String name) {
        return adminRepository.findByName(name)
                .map(oiAdmin -> {
                    return UserDetailsDTO
                            .builder()
                            .name(oiAdmin.getName())
                            .password(oiAdmin.getPassword())
                            .role(oiAdmin.getRole())
                            .build();
                }).switchIfEmpty(
                    managerRepository.findByName(name)
                    .map(oiManager -> {
                        return UserDetailsDTO
                                .builder()
                                .name(oiManager.getName())
                                .password(oiManager.getPassword())
                                .role(oiManager.getRole())
                                .build();
                    })
                ).switchIfEmpty(
                    waiterRepository.findByName(name)
                    .map(waiter -> {
                        return UserDetailsDTO
                                .builder()
                                .name(waiter.getName())
                                .password(waiter.getPassword())
                                .role(waiter.getRole())
                                .build();
                    })
                ).switchIfEmpty(
                    kitchenRepository.findByName(name)
                    .map(kitchen -> {
                        return UserDetailsDTO
                                .builder()
                                .name(kitchen.getName())
                                .password(kitchen.getPassword())
                                .role(kitchen.getRole())
                                .build();
                    })
                ).switchIfEmpty(
                    customerRepository.findByName(name)
                    .map(customer -> {
                        return UserDetailsDTO
                                .builder()
                                .name(customer.getName())
                                .password(customer.getPassword())
                                .role(customer.getRole())
                                .build();
                    })
                ).switchIfEmpty(
                    kitchenRepository.findByName(name)
                    .map(kitchen -> {
                        return UserDetailsDTO
                                .builder()
                                .name(kitchen.getName())
                                .password(kitchen.getPassword())
                                .role(kitchen.getRole())
                                .build();
                    })
                ).switchIfEmpty(
                    cupRepository.findByName(name)
                    .map(cup -> {
                        return UserDetailsDTO
                                .builder()
                                .name(cup.getName())
                                .password(cup.getPassword())
                                .role(cup.getRole())
                                .build();
                    })
                ).switchIfEmpty(
                    cardRepository.findByName(name)
                    .map(card -> {
                        return UserDetailsDTO
                                .builder()
                                .name(card.getName())
                                .password(card.getPassword())
                                .role(card.getRole())
                                .build();
                    })
                );
    }

    @Override
    public Mono<UserDTO> findByName(String name) {
        return adminRepository.findByName(name)
                .map(oiAdmin -> {
                    return UserDTO
                            .builder()
                            .name(oiAdmin.getName())
                            .role(oiAdmin.getRole())
                            .build();
                }).switchIfEmpty(
                    managerRepository.findByName(name)
                    .map(oiManager -> {
                        return UserDTO
                                .builder()
                                .name(oiManager.getName())
                                .role(oiManager.getRole())
                                .build();
                    })
                ).switchIfEmpty(
                    waiterRepository.findByName(name)
                    .map(waiter -> {
                        return UserDTO
                                .builder()
                                .name(waiter.getName())
                                .role(waiter.getRole())
                                .build();
                    })
                ).switchIfEmpty(
                    kitchenRepository.findByName(name)
                    .map(kitchen -> {
                        return UserDTO
                                .builder()
                                .name(kitchen.getName())
                                .role(kitchen.getRole())
                                .build();
                })).switchIfEmpty(
                    customerRepository.findByName(name)
                    .map(customer -> {
                        return UserDTO
                                .builder()
                                .name(customer.getName())
                                .role(customer.getRole())
                                .build();
                })).switchIfEmpty(
                    kitchenRepository.findByName(name)
                    .map(kitchen -> {
                        return UserDTO
                                .builder()
                                .name(kitchen.getName())
                                .role(kitchen.getRole())
                                .build();
                })).switchIfEmpty(
                    cupRepository.findByName(name)
                    .map(cup -> {
                        return UserDTO
                                .builder()
                                .name(cup.getName())
                                .role(cup.getRole())
                                .build();
                })).switchIfEmpty(
                    cardRepository.findByName(name)
                    .map(card -> {
                        return UserDTO
                                .builder()
                                .name(card.getName())
                                .role(card.getRole())
                                .build();
                }));
    }

    @Override
    public Mono<UserDTO> createUser(@Valid CreateUser createUser) {
        switch (createUser.getRole())
        {
            case ADMIN:
                return userMapper.fromAdminToDTO(adminRepository.save(userMapper.fromCreateUserToAdmin(createUser)));
            case MANAGER:
                return userMapper.fromManagerToDTO(managerRepository.save(userMapper.fromCreateUserToManager(createUser)));
            case CUSTOMER:
                return userMapper.fromCustomerToDTO(customerRepository.save(userMapper.fromCreateUserToCustomer(createUser)));
            case WAITER:
                return userMapper.fromWaiterToDTO(waiterRepository.save(userMapper.fromCreateUserToWaiter(createUser)));
            case KITCHEN:
                return userMapper.fromKitchenToDTO(kitchenRepository.save(userMapper.fromCreateUserToKitchen(createUser)));
            case CUP:
                return userMapper.fromCupToDTO(cupRepository.save(userMapper.fromCreateUserToCup(createUser)));
            case CARD:
                return userMapper.fromCardToDTO(cardRepository.save(userMapper.fromCreateUserToCard(createUser)));
        }
        throw new OiRoleNotFoundException();
    }

    @Override
    public Flux<UserDTO> findAllUsers() {
        return adminRepository.findAll().map(oiAdmin -> {
           return UserDTO
                   .builder()
                   .name(oiAdmin.getName())
                   .role(oiAdmin.getRole())
                   .build();
        }).concatWith(
            managerRepository.findAll().map(oiManager -> {
                return UserDTO
                        .builder()
                        .name(oiManager.getName())
                        .role(oiManager.getRole())
                        .build();
            })
        ).concatWith(
            customerRepository.findAll().map(customer -> {
                return UserDTO
                        .builder()
                        .name(customer.getName())
                        .role(customer.getRole())
                        .build();
            })
        ).concatWith(
            kitchenRepository.findAll().map(kitchen -> {
                return UserDTO
                        .builder()
                        .name(kitchen.getName())
                        .role(kitchen.getRole())
                        .build();
            })
        ).concatWith(
            cupRepository.findAll().map(cup -> {
                return UserDTO
                        .builder()
                        .name(cup.getName())
                        .role(cup.getRole())
                        .build();
            })
        ).concatWith(
            cardRepository.findAll().map(card -> {
                return UserDTO
                        .builder()
                        .name(card.getName())
                        .role(card.getRole())
                        .build();
            })
        ).concatWith(
            cardRepository.findAll().map(card -> {
                return UserDTO
                        .builder()
                        .name(card.getName())
                        .role(card.getRole())
                        .build();
            })
        );
    }

    @Override
    public Flux<UserDTO> findAllAdmins() {
        return adminRepository.findAll().map(oiAdmin -> {
            return UserDTO
                    .builder()
                    .name(oiAdmin.getName())
                    .role(oiAdmin.getRole())
                    .build();
        });
    }

    @Override
    public Flux<UserDTO> findAllManagers() {
        return managerRepository.findAll().map(oiManager -> {
            return UserDTO
                    .builder()
                    .name(oiManager.getName())
                    .role(oiManager.getRole())
                    .build();
        });
    }

    @Override
    public Flux<UserDTO> findAllCustomers() {
        return customerRepository.findAll().map(customer -> {
            return UserDTO
                    .builder()
                    .name(customer.getName())
                    .role(customer.getRole())
                    .build();
        });
    }

    @Override
    public Flux<UserDTO> findAllWaiters() {
        return waiterRepository.findAll().map(waiter -> {
            return UserDTO
                    .builder()
                    .name(waiter.getName())
                    .role(waiter.getRole())
                    .build();
        });
    }

    @Override
    public Flux<UserDTO> findAllKitchens() {
        return kitchenRepository.findAll().map(kitchen -> {
            return UserDTO
                    .builder()
                    .name(kitchen.getName())
                    .role(kitchen.getRole())
                    .build();
        });
    }

    @Override
    public Flux<UserDTO> findAllCups() {
        return cupRepository.findAll().map(cup -> {
            return UserDTO
                    .builder()
                    .name(cup.getName())
                    .role(cup.getRole())
                    .build();
        });
    }

    @Override
    public Flux<UserDTO> findAllCards() {
        return cardRepository.findAll().map(card -> {
            return UserDTO
                    .builder()
                    .name(card.getName())
                    .role(card.getRole())
                    .build();
        });
    }

}
