package br.com.neoholding.oi.garcom.service;

import br.com.neoholding.oi.garcom.model.command.CreateItem;
import br.com.neoholding.oi.garcom.model.dto.ItemDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

public interface ItemService {
    Mono<ItemDTO> creteItem(@Valid CreateItem createItem);
}
