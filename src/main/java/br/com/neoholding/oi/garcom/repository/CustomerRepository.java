package br.com.neoholding.oi.garcom.repository;

import br.com.neoholding.oi.garcom.model.entity.user.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String>
{
    Mono<Integer> findTopOrderNumberOrderByOrderNumber();

    Mono<Customer> findByName(String name);
}
