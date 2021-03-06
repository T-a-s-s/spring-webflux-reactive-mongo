package br.com.neoholding.oi.garcom.repository.user;

import br.com.neoholding.oi.garcom.model.entity.user.Cup;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CupRepository  extends ReactiveMongoRepository<Cup, String>
{
    Mono<Cup> findByName(String name);

    Flux<Cup> deleteByName(String s);
}
