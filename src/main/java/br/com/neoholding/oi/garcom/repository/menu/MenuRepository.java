package br.com.neoholding.oi.garcom.repository.menu;

import br.com.neoholding.oi.garcom.model.entity.menu.Menu;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MenuRepository extends ReactiveMongoRepository<Menu, String>
{
    Flux<Menu> deleteByName(String name);
}
