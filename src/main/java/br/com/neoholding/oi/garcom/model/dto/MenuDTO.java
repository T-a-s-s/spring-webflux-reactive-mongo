package br.com.neoholding.oi.garcom.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MenuDTO
{
    private String name;
    private Boolean flActive;
}
