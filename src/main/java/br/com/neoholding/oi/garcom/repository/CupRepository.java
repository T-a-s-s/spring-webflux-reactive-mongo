package br.com.neoholding.oi.garcom.repository;

import br.com.neoholding.oi.garcom.model.entity.user.Cup;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CupRepository  extends ReactiveMongoRepository<Cup, String>
{
    Mono<Integer> findTopOrderNumberOrderByOrderNumber();

    Mono<Cup> findByName(String name);
}
