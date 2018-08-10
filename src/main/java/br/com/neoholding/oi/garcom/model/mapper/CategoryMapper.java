package br.com.neoholding.oi.garcom.model.mapper;

import br.com.neoholding.oi.garcom.model.command.CreateCategory;
import br.com.neoholding.oi.garcom.model.dto.CategoryDTO;
import br.com.neoholding.oi.garcom.model.entity.menu.Category;
import br.com.neoholding.oi.garcom.repository.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CategoryMapper {

    MenuRepository menuRepository;

    @Autowired
    public CategoryMapper(MenuRepository menuRepository)
    {
        this.menuRepository = menuRepository;
    }

    public Category fromCreateCategoryToCategory(CreateCategory createCategory)
    {
        return Category
                .builder()
                .name(createCategory.getName())
                .build();
    }

    public CategoryDTO fromCategoryToDTO(Category category)
    {
        return CategoryDTO
                .builder()
                .name(category.getName())
                .build();
    }

    public Mono<CategoryDTO> fromCategoryMonoToDtoMono(Mono<Category> categoryMono)
    {
        return categoryMono.map(this::fromCategoryToDTO);
    }
}
