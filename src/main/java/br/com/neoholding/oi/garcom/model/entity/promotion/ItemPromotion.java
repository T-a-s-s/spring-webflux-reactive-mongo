package br.com.neoholding.oi.garcom.model.entity.promotion;

import br.com.neoholding.oi.garcom.model.entity.menu.Item;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "ItemPromotions")
public class ItemPromotion extends Promotion
{
	private Item item;
	private Integer orderNumber;
}
