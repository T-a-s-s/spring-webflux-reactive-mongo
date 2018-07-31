package br.com.neoholding.oi.garcom.model.entity.user;

import br.com.neoholding.oi.garcom.enumeration.OiRole;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Waiters")
public class Waiter extends OiUser
{
    private Integer orderNumber;

    @Builder
    public Waiter(String id, String name, String password, OiRole role, Integer orderNumber) {
        super(id, name, password, role);
        this.orderNumber = orderNumber;
    }
}
