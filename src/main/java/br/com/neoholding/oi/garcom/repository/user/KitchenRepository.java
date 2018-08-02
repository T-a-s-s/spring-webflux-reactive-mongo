package br.com.neoholding.oi.garcom.repository.user;

import br.com.neoholding.oi.garcom.model.entity.user.Kitchen;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface KitchenRepository extends ReactiveMongoRepository<Kitchen, String>
{
    Mono<Kitchen> findByName(String name);

    Flux<Kitchen> deleteByName(String s);
}
