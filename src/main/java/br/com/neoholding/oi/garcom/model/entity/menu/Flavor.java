package br.com.neoholding.oi.garcom.model.entity.menu;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Document(collection = "Flavors")
public class Flavor implements Serializable
{
	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal value;
	private Integer orderNumber;
	private Boolean flHidden;
	private String image;
	private String promotion;
	private String nutritionalInfo;
}
