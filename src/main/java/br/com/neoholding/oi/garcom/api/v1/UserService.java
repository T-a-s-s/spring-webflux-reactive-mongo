package br.com.neoholding.oi.garcom.api.v1;

import br.com.neoholding.oi.garcom.exception.OiRoleNotFoundException;
import br.com.neoholding.oi.garcom.mapper.UserMapper;
import br.com.neoholding.oi.garcom.model.command.CreateUser;
import br.com.neoholding.oi.garcom.model.dto.UserDTO;
import br.com.neoholding.oi.garcom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("v1/users")
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    WaiterRepository waiterRepository;
    @Autowired
    KitchenRepository kitchenRepository;
    @Autowired
    CupRepository cupRepository;
    @Autowired
    CardRepository cardRepository;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<UserDTO> getUserByName(@PathVariable(name="name") @NotNull @NotEmpty String name)
    {
        return userMapper.fromUserToDTO(userRepository.findByName(name));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserDTO> createUser(@RequestBody @Valid CreateUser createUser)
    {
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
}
