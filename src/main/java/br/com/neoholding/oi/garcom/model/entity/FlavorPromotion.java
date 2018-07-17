package br.com.neoholding.oi.garcom.model.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@DiscriminatorValue("FLAVOR")
public class FlavorPromotion extends Promotion
{
	@OneToOne 
	@JoinColumn(name="FLAVOR_ID", nullable=false)
	private Flavor flavor;
	
	@Column(name="ORDER_NUMBER", nullable=false)
	private Integer orderNumber;
}
