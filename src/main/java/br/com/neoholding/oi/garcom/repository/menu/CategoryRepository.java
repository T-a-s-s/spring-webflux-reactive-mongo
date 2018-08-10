package br.com.neoholding.oi.garcom.repository.menu;

import br.com.neoholding.oi.garcom.model.entity.menu.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CategoryRepository extends ReactiveMongoRepository<Category, String>
{
    Mono<Category> findByName(String name);
}
