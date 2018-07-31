package br.com.neoholding.oi.garcom.service;

import br.com.neoholding.oi.garcom.model.command.CreateMenu;
import br.com.neoholding.oi.garcom.model.dto.MenuDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MenuService
{
    Flux<MenuDTO> findAll();

    Mono<MenuDTO> createMenu(CreateMenu createMenu);
}
