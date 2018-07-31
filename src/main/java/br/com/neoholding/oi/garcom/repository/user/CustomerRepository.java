package br.com.neoholding.oi.garcom.repository.user;

import br.com.neoholding.oi.garcom.model.entity.user.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String>
{
    Mono<Customer> findByName(String name);
}
