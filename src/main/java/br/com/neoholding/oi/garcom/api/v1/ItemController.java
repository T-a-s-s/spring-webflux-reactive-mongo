package br.com.neoholding.oi.garcom.api.v1;

import br.com.neoholding.oi.garcom.model.command.CreateItem;
import br.com.neoholding.oi.garcom.model.dto.ItemDTO;
import br.com.neoholding.oi.garcom.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("oi-garcom-api/v1/items")
public class ItemController {

    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ItemDTO> createItem(@RequestBody @Valid CreateItem createItem)
    {
        return itemService.creteItem(createItem);
    }
}
