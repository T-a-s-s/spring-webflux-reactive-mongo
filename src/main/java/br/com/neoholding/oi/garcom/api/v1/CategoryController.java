package br.com.neoholding.oi.garcom.api.v1;

import br.com.neoholding.oi.garcom.model.command.CreateCategory;
import br.com.neoholding.oi.garcom.model.dto.CategoryDTO;
import br.com.neoholding.oi.garcom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("oi-garcom-api/v1/categories")
public class CategoryController
{
    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CategoryDTO> createCategory(@RequestBody @Valid CreateCategory createCategory)
    {
        return categoryService.createCategory(createCategory);
    }
}
