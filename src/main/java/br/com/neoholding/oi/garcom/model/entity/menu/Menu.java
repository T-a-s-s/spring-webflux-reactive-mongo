package br.com.neoholding.oi.garcom.model.entity.menu;

import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

@Getter
public class Menu implements Serializable
{
	@Id
	private String id;
	private String name;
	private Boolean flActive;
	private Integer orderNumber;
	private List<Item> items;
}
