package br.com.neoholding.oi.garcom.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Entity
@Table(name="MENU")
public class Menu implements Serializable 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private Integer id;

	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="FL_ACTIVE", nullable=false)
	private Boolean flActive;
	
	@Column(name="ORDER_NUMBER", nullable=false)
	private Integer orderNumber;	
	
	@OneToMany(mappedBy="menu")
	private List<Item> items;
}
