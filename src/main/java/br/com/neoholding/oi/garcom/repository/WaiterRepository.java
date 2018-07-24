package br.com.neoholding.oi.garcom.repository;

import br.com.neoholding.oi.garcom.model.entity.user.Waiter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaiterRepository extends MongoRepository<Waiter, String>
{
    Integer findTopOrderNumberOrderByOrderNumber();
}
