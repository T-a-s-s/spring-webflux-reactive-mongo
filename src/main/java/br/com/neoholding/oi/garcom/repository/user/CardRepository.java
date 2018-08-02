package br.com.neoholding.oi.garcom.repository.user;

import br.com.neoholding.oi.garcom.model.entity.user.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CardRepository extends ReactiveMongoRepository<Card, String>
{
    Mono<Card> findByName(String name);

    Flux<Card> deleteByName(String s);
}
