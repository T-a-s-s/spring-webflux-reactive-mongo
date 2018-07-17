package br.com.neoholding.oi.garcom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;

@Getter 
@Entity
@Table(name="CATEGORY")
public class Flavor implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="VALUE", nullable=false)
	private BigDecimal value;
	
	@Column(name="DESCRIPTION", nullable=false)
	private String description;
	
	@Column(name="ORDER_NUMBER", nullable=false)
	private Integer orderNumber;
	
	@Column(name="FL_HIDDEN", nullable=false)
	private Boolean flHidden;
	
	@Column(name = "IMAGE", nullable= false)
	private byte[] image;
	
	@Column(name = "IMAGE_CONTENT_TYPE", nullable = false)
	private String imageContentType;
	
	@ManyToOne
	@JoinColumn(name="ITEM_ID", nullable=false)
	private Item item;
	
	@OneToOne(mappedBy="flavor")
	private Promotion promotion;
	
	@OneToOne(mappedBy="flavor")
	private NutritionalInfo nutritionalInfo;
}
