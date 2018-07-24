package br.com.neoholding.oi.garcom.model.entity.promotion;

import br.com.neoholding.oi.garcom.model.entity.menu.Item;
import lombok.Getter;

@Getter
public class ItemPromotion extends Promotion
{
	private Item item;
	private Integer orderNumber;
}
