package br.com.neoholding.oi.garcom.service;

import br.com.neoholding.oi.garcom.model.command.CreateMenu;
import br.com.neoholding.oi.garcom.model.command.DeleteMenu;
import br.com.neoholding.oi.garcom.model.command.PatchMenu;
import br.com.neoholding.oi.garcom.model.dto.MenuDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface MenuService
{
    Flux<MenuDTO> findAll();

    Mono<MenuDTO> createMenu(CreateMenu createMenu);

    Flux<MenuDTO> deleteByName(DeleteMenu deleteMenu);

    Mono<MenuDTO> patchMenu(String name, @NotNull @NotEmpty PatchMenu patchMenu);
}
