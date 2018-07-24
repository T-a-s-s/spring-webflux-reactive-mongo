package br.com.neoholding.oi.garcom.model.entity.menu;

import br.com.neoholding.oi.garcom.enumeration.Destination;
import br.com.neoholding.oi.garcom.model.entity.promotion.Promotion;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter 
public class Item implements Serializable
{
	@Id
	private String id;
	private String name;
	private BigDecimal value;
	private String description;
	private Integer orderNumber;
	private Boolean FlHidden;
	private Destination destination;
	private byte[] image;
	private String imageContentType;
	private Category category;
	private Menu menu;
	private Promotion promotion;
	private List<Flavor> flavors;
	private List<OrderItem> orderItems;
	private NutritionalInfo nutritionalInfo;
}
