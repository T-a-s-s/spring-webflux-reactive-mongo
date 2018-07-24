package br.com.neoholding.oi.garcom.api.v1;

import br.com.neoholding.oi.garcom.mapper.UserMapper;
import br.com.neoholding.oi.garcom.model.command.CreateUser;
import br.com.neoholding.oi.garcom.model.dto.UserDTO;
import br.com.neoholding.oi.garcom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserByName(@PathVariable(name="name") String name)
    {
        return userMapper.fromUserToDTO(userRepository.findByName(name));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody CreateUser createUser)
    {
        switch (createUser.getRole())
        {
            case ADMIN:
                return userMapper.fromUserToDTO(userRepository.save(userMapper.fromCreateUserToAdmin(createUser)));
            case MANAGER:
                return userMapper.fromUserToDTO(userRepository.save(userMapper.fromCreateUserToManager(createUser)));
            case CUSTOMER:
                return userMapper.fromUserToDTO(userRepository.save(userMapper.fromCreateUserToCustomer(createUser)));
            case WAITER:
                return userMapper.fromUserToDTO(userRepository.save(userMapper.fromCreateUserToWaiter(createUser)));
            case KITCHEN:
                return userMapper.fromUserToDTO(userRepository.save(userMapper.fromCreateUserToKitchen(createUser)));
            case CUP:
                return userMapper.fromUserToDTO(userRepository.save(userMapper.fromCreateUserToCup(createUser)));
            case CARD:
                return userMapper.fromUserToDTO(userRepository.save(userMapper.fromCreateUserToCard(createUser)));
        }
        return null;
    }
}
