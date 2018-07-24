package br.com.neoholding.oi.garcom.repository;

import br.com.neoholding.oi.garcom.model.entity.user.Cup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupRepository  extends MongoRepository<Cup, String>
{
    Integer findTopOrderNumberOrderByOrderNumber();
}
