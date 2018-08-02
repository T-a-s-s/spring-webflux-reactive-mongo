package br.com.neoholding.oi.garcom.api.v1;

import br.com.neoholding.oi.garcom.model.command.CreateMenu;
import br.com.neoholding.oi.garcom.model.command.DeleteMenu;
import br.com.neoholding.oi.garcom.model.dto.MenuDTO;
import br.com.neoholding.oi.garcom.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("oi-garcom-api/v1/menus")
public class MenuController {

    MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Flux<MenuDTO> findAll() {
        return menuService.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MenuDTO> createMenu(@RequestBody @Valid CreateMenu createMenu) {
        return menuService.createMenu(createMenu);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Flux<MenuDTO> deleteMenu(@NotNull @NotEmpty @RequestBody DeleteMenu deleteMenu){
        return menuService.deleteByName(deleteMenu);
    }
}
