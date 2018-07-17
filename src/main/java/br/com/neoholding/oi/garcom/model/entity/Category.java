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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;

@Getter 
@Entity
@Table(name="CATEGORY")
public class Category  implements Serializable 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="description_ic", nullable=false)
	private String descriptionIc;
	
	@Column(name="ORDER_NUMBER", nullable=false)
	private Integer orderNumber;
	
	@OneToMany(mappedBy="category")
	private List<Item> items;
	
	@OneToOne
	@JoinColumn(name="MENU_ID")
	private Menu nlMenu;

}
