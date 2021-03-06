package br.com.neoholding.oi.garcom.repository.user;

import br.com.neoholding.oi.garcom.model.entity.user.OiManager;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ManagerRepository extends ReactiveMongoRepository<OiManager, String>
{
    Mono<OiManager> findByName(String name);

    Flux<OiManager> deleteByName(String s);
}
