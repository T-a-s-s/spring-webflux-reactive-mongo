package br.com.neoholding.oi.garcom.repository;

import br.com.neoholding.oi.garcom.model.entity.user.Waiter;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface WaiterRepository extends ReactiveMongoRepository<Waiter, String>
{
    Mono<Integer> findTopOrderNumberOrderByOrderNumber();

    Mono<Waiter> findByName(String name);
}
