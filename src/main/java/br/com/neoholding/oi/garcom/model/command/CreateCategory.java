package br.com.neoholding.oi.garcom.model.command;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateCategory
{
    @NotNull
    String name;
    @NotNull
    String menu;
}
