package br.com.neoholding.oi.garcom.model.entity.promotion;

import br.com.neoholding.oi.garcom.model.entity.menu.Flavor;
import lombok.Getter;

@Getter
public class FlavorPromotion extends Promotion
{
	private Flavor flavor;
	private Integer orderNumber;
}
