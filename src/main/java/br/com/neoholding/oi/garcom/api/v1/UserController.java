package br.com.neoholding.oi.garcom.api.v1;

import br.com.neoholding.oi.garcom.model.command.CreateUser;
import br.com.neoholding.oi.garcom.model.command.DeleteUser;
import br.com.neoholding.oi.garcom.model.dto.UserDTO;
import br.com.neoholding.oi.garcom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("oi-garcom-api/v1/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<UserDTO> getUserByName(@PathVariable(name="name") @NotNull @NotEmpty String name)
    {
        return userService.findByName(name);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserDTO> findAllUsers()
    {
        return userService.findAllUsers();
    }

    @GetMapping("/admins")
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserDTO> findAllAdmins()
    {
        return userService.findAllAdmins();
    }

    @GetMapping("/managers")
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserDTO> findAllManagers()
    {
        return userService.findAllManagers();
    }

    @GetMapping("/waiters")
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserDTO> findAllWaiters()
    {
        return userService.findAllWaiters();
    }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserDTO> findAllCustomers()
    {
        return userService.findAllCustomers();
    }

    @GetMapping("/kitchens")
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserDTO> findAllKitchens()
    {
        return userService.findAllKitchens();
    }

    @GetMapping("/cups")
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserDTO> findAllCups()
    {
        return userService.findAllCups();
    }

    @GetMapping("/cards")
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserDTO> findAllCards()
    {
        return userService.findAllCards();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserDTO> createUser(@RequestBody @Valid CreateUser createUser)
    {
        return userService.createUser(createUser);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserDTO> deleteByName(@NotNull @NotEmpty @RequestBody DeleteUser deleteUser)
    {
        return userService.deleteByName(deleteUser);
    }
}
