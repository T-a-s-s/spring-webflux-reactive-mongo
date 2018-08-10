package br.com.neoholding.oi.garcom.model.entity.menu;

import br.com.neoholding.oi.garcom.enumeration.Destination;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@Document(collection = "Items")
public class Item implements Serializable
{
	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal value;
	private Destination destination;
	private Integer orderNumber;
	private Boolean FlHidden;
	private String image;
	private String promotion;
	private List<String> flavors;
	private String nutritionalInfo;
}
