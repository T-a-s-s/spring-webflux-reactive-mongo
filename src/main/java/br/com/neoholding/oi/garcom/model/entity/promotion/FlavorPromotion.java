package br.com.neoholding.oi.garcom.model.entity.promotion;

import br.com.neoholding.oi.garcom.model.entity.menu.Flavor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "FlavorPromotions")
public class FlavorPromotion extends Promotion
{
	private Flavor flavor;
	private Integer orderNumber;
}
