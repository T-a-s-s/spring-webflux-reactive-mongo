package br.com.neoholding.oi.garcom.model.command;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateMenu
{
    @NotNull
    String name;
}
