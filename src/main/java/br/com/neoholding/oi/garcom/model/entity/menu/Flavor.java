package br.com.neoholding.oi.garcom.model.entity.menu;

import br.com.neoholding.oi.garcom.model.entity.promotion.Promotion;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter 
public class Flavor implements Serializable
{
	@Id
	private String id;
	private String name;
	private BigDecimal value;
	private String description;
	private Integer orderNumber;
	private Boolean flHidden;
	private byte[] image;
	private String imageContentType;
	private Item item;
	private Promotion promotion;
	private NutritionalInfo nutritionalInfo;
}
