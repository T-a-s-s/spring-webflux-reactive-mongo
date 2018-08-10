package br.com.neoholding.oi.garcom.model.mapper;

import br.com.neoholding.oi.garcom.model.command.CreateMenu;
import br.com.neoholding.oi.garcom.model.dto.MenuDTO;
import br.com.neoholding.oi.garcom.model.entity.menu.Menu;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MenuMapper {
    public MenuDTO fromMenuToDTO(Menu menu) {
        return MenuDTO
                .builder()
                .name(menu.getName().toUpperCase())
                .flActive(menu.getFlActive())
                .build();
    }

    public Menu fromCreateMenuToMenu(CreateMenu createMenu) {
        return Menu
                .builder()
                .name(createMenu.getName().toUpperCase())
                .flActive(false)
                .build();
    }

    public Mono<MenuDTO> fromMenuMonoToDtoMono(Mono<Menu> menu) {
        return menu.map(this::fromMenuToDTO);
    }
}
