package br.com.neoholding.oi.garcom.model.dto;

import br.com.neoholding.oi.garcom.enumeration.OiRole;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDTO
{
    String name;
    OiRole role;
}
