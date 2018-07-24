package br.com.neoholding.oi.garcom.mapper;

import br.com.neoholding.oi.garcom.model.command.CreateUser;
import br.com.neoholding.oi.garcom.model.dto.UserDTO;
import br.com.neoholding.oi.garcom.model.entity.user.*;
import br.com.neoholding.oi.garcom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    KitchenRepository  kitchenRepository;
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    WaiterRepository waiterRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CupRepository cupRepository;

    public UserDTO fromUserToDTO(OiUser user) {
        return UserDTO
                .builder()
                .name(user.getName())
                .role(user.getRole())
                .build();
    }

    public OiAdmin fromCreateUserToAdmin(CreateUser createUser) {
        return OiAdmin
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .orderNumber(adminRepository.findTopOrderNumberOrderByOrderNumber())
                .build();
    }

    public OiManager fromCreateUserToManager(CreateUser createUser) {
        return OiManager
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .orderNumber(managerRepository.findTopOrderNumberOrderByOrderNumber())
                .build();
    }

    public Customer fromCreateUserToCustomer(CreateUser createUser) {
        return Customer
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .orderNumber(customerRepository.findTopOrderNumberOrderByOrderNumber())
                .build();
    }

    public Waiter fromCreateUserToWaiter(CreateUser createUser) {
        return Waiter
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .orderNumber(waiterRepository.findTopOrderNumberOrderByOrderNumber())
                .build();
    }

    public Kitchen fromCreateUserToKitchen(CreateUser createUser) {
        return Kitchen
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .orderNumber(kitchenRepository.findTopOrderNumberOrderByOrderNumber())
                .build();
    }

    public Cup fromCreateUserToCup(CreateUser createUser) {
        return Cup
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .orderNumber(cupRepository.findTopOrderNumberOrderByOrderNumber())
                .build();
    }

    public Card fromCreateUserToCard(CreateUser createUser) {
        return Card
                .builder()
                .name(createUser.getName())
                .password(createUser.getPassword())
                .role(createUser.getRole())
                .orderNumber(cardRepository.findTopOrderNumberOrderByOrderNumber())
                .build();
    }
}
