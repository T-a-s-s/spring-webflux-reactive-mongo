package br.com.neoholding.oi.garcom.model.command;

import br.com.neoholding.oi.garcom.enumeration.OiRole;
import lombok.Getter;

public class PatchUser
{
    @Getter
    String name;
    @Getter
    OiRole role;
}
