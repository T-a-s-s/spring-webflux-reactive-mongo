package br.com.neoholding.oi.garcom.service.impl;

import br.com.neoholding.oi.garcom.model.command.CreateMenu;
import br.com.neoholding.oi.garcom.model.command.DeleteMenu;
import br.com.neoholding.oi.garcom.model.command.PatchMenu;
import br.com.neoholding.oi.garcom.model.dto.MenuDTO;
import br.com.neoholding.oi.garcom.model.mapper.MenuMapper;
import br.com.neoholding.oi.garcom.repository.menu.MenuRepository;
import br.com.neoholding.oi.garcom.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MenuServiceImpl implements MenuService
{
    MenuRepository menuRepository;
    MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository,
                           MenuMapper menuMapper) {
        this.menuRepository = menuRepository;
        this.menuMapper = menuMapper;
    }

    @Override
    public Flux<MenuDTO> findAll()
    {
        return menuRepository.findAll().map( menu -> { return menuMapper.fromMenuToDTO(menu); });
    }

    @Override
    public Mono<MenuDTO> createMenu(CreateMenu createMenu)
    {
        return menuMapper.fromMenuMonoToDtoMono(menuRepository.save(menuMapper.fromCreateMenuToMenu(createMenu)));
    }

    @Override
    public Flux<MenuDTO> deleteByName(DeleteMenu deleteMenu)
    {
        return menuRepository.deleteByName(deleteMenu.getName().toUpperCase()).map( menu -> { return menuMapper.fromMenuToDTO(menu); });
    }

    @Override
    public Mono<MenuDTO> patchMenu(String name, PatchMenu patchMenu)
    {
        return menuRepository.findByName(name.toUpperCase())
                .flatMap(menu -> {
                    menu.setName(patchMenu.getName().toUpperCase());
                    return menuRepository.save(menu);
                }).map(updatedMenu -> {
                    return MenuDTO
                            .builder()
                            .name(updatedMenu.getName())
                            .flActive(updatedMenu.getFlActive())
                            .build();
                });
    }
}
