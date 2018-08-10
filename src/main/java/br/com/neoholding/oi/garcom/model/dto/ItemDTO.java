package br.com.neoholding.oi.garcom.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class ItemDTO
{
    String name;
    String description;
    BigDecimal value;
}
