package br.com.neoholding.oi.garcom.model.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;

@Getter
@DiscriminatorValue("ITEM")
public class ItemPromotion extends Promotion
{
	@OneToOne 
	@JoinColumn(name="ITEM_ID", nullable=false)
	private Item item;
	
	@Column(name="ORDER_NUMBER", nullable=false)
	private Integer orderNumber;
}
