package br.com.neoholding.oi.garcom.repository;

import br.com.neoholding.oi.garcom.model.entity.user.Kitchen;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface KitchenRepository extends ReactiveMongoRepository<Kitchen, String>
{
    Mono<Integer> findTopOrderNumberOrderByOrderNumber();

    Mono<Kitchen> findByName(String name);
}
