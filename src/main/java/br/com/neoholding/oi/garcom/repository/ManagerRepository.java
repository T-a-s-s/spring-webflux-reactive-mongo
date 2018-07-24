package br.com.neoholding.oi.garcom.repository;

import br.com.neoholding.oi.garcom.model.entity.user.OiManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository  extends MongoRepository<OiManager, String>
{
    Integer findTopOrderNumberOrderByOrderNumber();
}
