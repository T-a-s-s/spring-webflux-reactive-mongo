package br.com.neoholding.oi.garcom.model.entity.user;

import br.com.neoholding.oi.garcom.enumeration.OiRole;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Managers")
public class OiManager extends OiUser
{
    private Integer orderNumber;

    @Builder
    public OiManager(String id, String name, String password, OiRole role, Integer orderNumber) {
        super(id, name, password, role);
        this.orderNumber = orderNumber;
    }
}
