package br.com.neoholding.oi.garcom.repository;

import br.com.neoholding.oi.garcom.model.entity.user.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CardRepository extends ReactiveMongoRepository<Card, String>
{
    Mono<Integer> findTopOrderNumberOrderByOrderNumber();

    Mono<Card> findByName(String name);
}
