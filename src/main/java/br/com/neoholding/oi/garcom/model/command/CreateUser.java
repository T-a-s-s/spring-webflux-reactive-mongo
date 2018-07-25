package br.com.neoholding.oi.garcom.model.command;

import br.com.neoholding.oi.garcom.enumeration.OiRole;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateUser {
    @NotNull
    String name;
    @NotNull
    String password;
    @NotNull
    OiRole role;
}
