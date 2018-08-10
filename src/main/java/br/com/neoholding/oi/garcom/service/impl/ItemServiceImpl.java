package br.com.neoholding.oi.garcom.service.impl;

import br.com.neoholding.oi.garcom.model.command.CreateItem;
import br.com.neoholding.oi.garcom.model.dto.ItemDTO;
import br.com.neoholding.oi.garcom.model.mapper.ItemMapper;
import br.com.neoholding.oi.garcom.repository.menu.ItemRepository;
import br.com.neoholding.oi.garcom.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
public class ItemServiceImpl implements ItemService {

    ItemMapper itemMapper;
    ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemMapper itemMapper, ItemRepository itemRepository) {
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
    }

    @Override
    public Mono<ItemDTO> creteItem(@Valid CreateItem createItem) {
        return itemMapper.fromMenuMonoToDtoMono(itemRepository.save(itemMapper.fromCreateItemToItem(createItem)));
    }
}
