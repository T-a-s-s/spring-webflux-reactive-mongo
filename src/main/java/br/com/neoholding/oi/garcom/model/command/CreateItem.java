package br.com.neoholding.oi.garcom.model.command;

import br.com.neoholding.oi.garcom.enumeration.Destination;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class CreateItem
{
    @NotNull
    String name;
    @NotNull
    String description;
    @NotNull
    BigDecimal value;
    @NotNull
    Destination destination;
    @NotNull
    String category;
}
