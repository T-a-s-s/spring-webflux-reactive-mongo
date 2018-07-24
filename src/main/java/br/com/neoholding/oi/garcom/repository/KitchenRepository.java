package br.com.neoholding.oi.garcom.repository;

import br.com.neoholding.oi.garcom.model.entity.user.Kitchen;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitchenRepository extends MongoRepository<Kitchen, String>
{
    Integer findTopOrderNumberOrderByOrderNumber();
}
