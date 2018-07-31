package br.com.neoholding.oi.garcom.service.impl;

import br.com.neoholding.oi.garcom.exception.OiRoleNotFoundException;
import br.com.neoholding.oi.garcom.model.command.CreateUser;
import br.com.neoholding.oi.garcom.model.dto.UserDTO;
import br.com.neoholding.oi.garcom.model.dto.UserDetailsDTO;
import br.com.neoholding.oi.garcom.model.mapper.UserMapper;
import br.com.neoholding.oi.garcom.repository.user.*;
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
        return adminRepository.findByName(name.toUpperCase())
                    .map(oiAdmin -> { return userMapper.fromAdminToUserDetailsDTO(oiAdmin); }
            ).switchIfEmpty(
                managerRepository.findByName(name.toUpperCase())
                    .map(oiManager -> { return userMapper.fromManagerToUserDetailsDTO(oiManager); })
            ).switchIfEmpty(
                waiterRepository.findByName(name.toUpperCase())
                    .map(waiter -> { return userMapper.fromWaiterToUserDetailsDTO(waiter); })
            ).switchIfEmpty(
                kitchenRepository.findByName(name.toUpperCase())
                    .map(kitchen -> { return userMapper.fromKitchenToUserDetailsDTO(kitchen); })
            ).switchIfEmpty(
                customerRepository.findByName(name.toUpperCase())
                    .map(customer -> { return userMapper.fromCustomerToUserDetailsDTO(customer); })
            ).switchIfEmpty(
                cupRepository.findByName(name.toUpperCase())
                    .map(cup -> { return userMapper.fromCupToUserDetailsDTO(cup); })
            ).switchIfEmpty(
                cardRepository.findByName(name.toUpperCase())
                    .map(card -> { return userMapper.fromCardToUserDetailsDTO(card); })
            );
    }

    @Override
    public Mono<UserDTO> findByName(String name) {
        return adminRepository.findByName(name.toUpperCase())
                    .map(oiAdmin -> { return userMapper.fromAdminToDTO(oiAdmin); }
            ).switchIfEmpty(
                managerRepository.findByName(name.toUpperCase())
                    .map(oiManager -> { return userMapper.fromManagerToDTO(oiManager); })
            ).switchIfEmpty(
                waiterRepository.findByName(name.toUpperCase())
                    .map(waiter -> { return userMapper.fromWaiterToDTO(waiter); })
            ).switchIfEmpty(
                kitchenRepository.findByName(name.toUpperCase())
                    .map(kitchen -> { return userMapper.fromKitchenToDTO(kitchen); })
            ).switchIfEmpty(
                customerRepository.findByName(name.toUpperCase())
                    .map(customer -> { return userMapper.fromCustomerToDTO(customer); })
            ).switchIfEmpty(
                kitchenRepository.findByName(name.toUpperCase())
                    .map(kitchen -> { return userMapper.fromKitchenToDTO(kitchen); })
            ).switchIfEmpty(
                cupRepository.findByName(name.toUpperCase())
                    .map(cup -> { return userMapper.fromCupToDTO(cup);
            })).switchIfEmpty(
                cardRepository.findByName(name.toUpperCase())
                    .map(card -> { return userMapper.fromCardToDTO(card);})
            );
    }

    @Override
    public Mono<UserDTO> createUser(@Valid CreateUser createUser) {
        switch (createUser.getRole())
        {
            case ADMIN:
                return userMapper.fromAdminMonoToDtoMono(adminRepository.save(userMapper.fromCreateUserToAdmin(createUser)));
            case MANAGER:
                return userMapper.fromManagerMonoToDtoMono(managerRepository.save(userMapper.fromCreateUserToManager(createUser)));
            case CUSTOMER:
                return userMapper.fromCustomerMonoToDtoMono(customerRepository.save(userMapper.fromCreateUserToCustomer(createUser)));
            case WAITER:
                return userMapper.fromWaiterMonoToDtoMono(waiterRepository.save(userMapper.fromCreateUserToWaiter(createUser)));
            case KITCHEN:
                return userMapper.fromKitchenMonoToDtoMono(kitchenRepository.save(userMapper.fromCreateUserToKitchen(createUser)));
            case CUP:
                return userMapper.fromCupMonoToDtoMono(cupRepository.save(userMapper.fromCreateUserToCup(createUser)));
            case CARD:
                return userMapper.fromCardMonoToDtoMono(cardRepository.save(userMapper.fromCreateUserToCard(createUser)));
        }
        throw new OiRoleNotFoundException();
    }

    @Override
    public Flux<UserDTO> findAllUsers() {
        return adminRepository.findAll().map(oiAdmin -> {
            return userMapper.fromAdminToDTO(oiAdmin);
        }).concatWith(
            managerRepository.findAll().map(oiManager -> {
                return userMapper.fromManagerToDTO(oiManager);
            })
        ).concatWith(
            waiterRepository.findAll().map(waiter -> {
                return userMapper.fromWaiterToDTO(waiter);
            })
        ).concatWith(
            customerRepository.findAll().map(customer -> {
                return userMapper.fromCustomerToDTO(customer);
            })
        ).concatWith(
            kitchenRepository.findAll().map(kitchen -> {
                return userMapper.fromKitchenToDTO(kitchen);
            })
        ).concatWith(
            cupRepository.findAll().map(cup -> {
                return userMapper.fromCupToDTO(cup);
            })
        ).concatWith(
            cardRepository.findAll().map(card -> {
                return userMapper.fromCardToDTO(card);
            })
        );
    }

    @Override
    public Flux<UserDTO> findAllAdmins() {
        return adminRepository.findAll().map(oiAdmin -> {
            return userMapper.fromAdminToDTO(oiAdmin);
        });
    }

    @Override
    public Flux<UserDTO> findAllManagers() {
        return managerRepository.findAll().map(oiManager -> {
            return userMapper.fromManagerToDTO(oiManager);
        });
    }

    @Override
    public Flux<UserDTO> findAllCustomers() {
        return customerRepository.findAll().map(customer -> {
            return userMapper.fromCustomerToDTO(customer);
        });
    }

    @Override
    public Flux<UserDTO> findAllWaiters() {
        return waiterRepository.findAll().map(waiter -> {
            return userMapper.fromWaiterToDTO(waiter);
        });
    }

    @Override
    public Flux<UserDTO> findAllKitchens() {
        return kitchenRepository.findAll().map(kitchen -> {
            return userMapper.fromKitchenToDTO(kitchen);
        });
    }

    @Override
    public Flux<UserDTO> findAllCups() {
        return cupRepository.findAll().map(cup -> {
            return userMapper.fromCupToDTO(cup);
        });
    }

    @Override
    public Flux<UserDTO> findAllCards() {
        return cardRepository.findAll().map(card -> {
            return userMapper.fromCardToDTO(card);
        });
    }

}
