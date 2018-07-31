package br.com.neoholding.oi.garcom.repository;

import br.com.neoholding.oi.garcom.model.entity.user.OiAdmin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AdminRepository extends ReactiveMongoRepository<OiAdmin, String>
{
    Mono<Integer> findTopOrderNumberOrderByOrderNumber();

    Mono<OiAdmin> findByName(String name);
}
