package br.com.neoholding.oi.garcom.repository.user;

import br.com.neoholding.oi.garcom.model.entity.user.Waiter;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface WaiterRepository extends ReactiveMongoRepository<Waiter, String>
{
    Mono<Waiter> findByName(String name);

    Flux<Waiter> deleteByName(String s);
}
