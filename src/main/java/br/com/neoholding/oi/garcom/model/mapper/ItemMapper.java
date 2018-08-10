package br.com.neoholding.oi.garcom.model.mapper;

import br.com.neoholding.oi.garcom.model.command.CreateItem;
import br.com.neoholding.oi.garcom.model.dto.ItemDTO;
import br.com.neoholding.oi.garcom.model.entity.menu.Item;
import br.com.neoholding.oi.garcom.repository.menu.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ItemMapper {

    CategoryRepository categoryRepository;

    @Autowired
    public ItemMapper(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    public Item fromCreateItemToItem(CreateItem createItem)
    {
        return Item
                .builder()
                .description(createItem.getDescription())
                .destination(createItem.getDestination())
                .value(createItem.getValue())
                .FlHidden(false)
                .build();
    }

    public ItemDTO fromItemToDTO(Item item)
    {
        return ItemDTO
                .builder()
                .name(item.getName())
                .description(item.getDescription())
                .value(item.getValue())
                .build();
    }

    public Mono<ItemDTO> fromMenuMonoToDtoMono(Mono<Item> itemMono)
    {
        return itemMono.map(this::fromItemToDTO);
    }
}
