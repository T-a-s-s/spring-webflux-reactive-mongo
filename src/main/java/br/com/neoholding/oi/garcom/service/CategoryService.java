package br.com.neoholding.oi.garcom.service;

import br.com.neoholding.oi.garcom.model.command.CreateCategory;
import br.com.neoholding.oi.garcom.model.dto.CategoryDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

public interface CategoryService {
    Mono<CategoryDTO> createCategory(@Valid CreateCategory createCategory);
}
