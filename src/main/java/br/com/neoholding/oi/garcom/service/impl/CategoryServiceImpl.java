package br.com.neoholding.oi.garcom.service.impl;

import br.com.neoholding.oi.garcom.model.command.CreateCategory;
import br.com.neoholding.oi.garcom.model.dto.CategoryDTO;
import br.com.neoholding.oi.garcom.model.mapper.CategoryMapper;
import br.com.neoholding.oi.garcom.repository.menu.CategoryRepository;
import br.com.neoholding.oi.garcom.repository.menu.MenuRepository;
import br.com.neoholding.oi.garcom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService
{
    MenuRepository menuRepository;
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               CategoryMapper categoryMapper,
                               MenuRepository menuRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.menuRepository = menuRepository;
    }

    @Override
    public Mono<CategoryDTO> createCategory(@Valid CreateCategory createCategory) {
        return categoryMapper.fromCategoryMonoToDtoMono
                (categoryRepository.save(categoryMapper.fromCreateCategoryToCategory(createCategory))
                        .map(category -> {
                            menuRepository.findByName(createCategory.getMenu())
                                    .subscribe(menu -> {
                                        if(menu.getCategories() != null) {
                                            menu.getCategories().add(category.getId());
                                        } else {
                                            List<String> categories = new ArrayList<String>();
                                            categories.add(category.getId());
                                            menu.setCategories(categories);
                                        }
                                        menuRepository.save(menu).subscribe();
                                    });
                            return category;
                        })
                );
    }
}
