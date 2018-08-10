package br.com.neoholding.oi.garcom.repository.menu;

import br.com.neoholding.oi.garcom.model.entity.menu.Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ReactiveMongoRepository<Item, String> {
}
