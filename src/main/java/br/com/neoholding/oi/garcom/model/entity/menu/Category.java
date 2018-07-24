package br.com.neoholding.oi.garcom.model.entity.menu;

import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

@Getter 
public class Category  implements Serializable
{
	@Id
	private String id;
	private String descriptionIc;
	private Integer orderNumber;
	private List<Item> items;
	private Menu nlMenu;

}
