package br.com.neoholding.oi.garcom.model.command;

import br.com.neoholding.oi.garcom.enumeration.OiRole;
import lombok.Getter;

@Getter
public class CreateUser {
    String name;
    String password;
    OiRole role;
}
