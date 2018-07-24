package br.com.neoholding.oi.garcom.model.entity.user;

import br.com.neoholding.oi.garcom.enumeration.OiRole;
import lombok.Builder;

public class Customer extends OiUser
{
    private Integer orderNumber;

    @Builder
    public Customer(String id, String name, String password, OiRole role, Integer orderNumber) {
        super(id, name, password, role);
        this.orderNumber = orderNumber;
    }
}