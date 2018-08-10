package br.com.neoholding.oi.garcom.repository.menu;

import br.com.neoholding.oi.garcom.model.entity.menu.Menu;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Repository
public interface MenuRepository extends ReactiveMongoRepository<Menu, String>
{
    Flux<Menu> deleteByName(String name);

    Mono<Menu> findByName(@NotNull @NotEmpty String name);
}
