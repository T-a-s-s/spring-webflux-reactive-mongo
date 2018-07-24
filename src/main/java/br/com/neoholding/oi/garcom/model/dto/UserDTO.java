package br.com.neoholding.oi.garcom.model.dto;

import br.com.neoholding.oi.garcom.enumeration.OiRole;
import lombok.Builder;

@Builder
public class UserDTO
{
    String name;
    OiRole role;
}
