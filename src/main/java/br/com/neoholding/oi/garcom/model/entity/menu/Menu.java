package br.com.neoholding.oi.garcom.model.entity.menu;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@Document(collection = "Menus")
public class Menu implements Serializable
{
	@Id
	private String id;
	@Setter
	private String name;
	private Boolean flActive;
	private Integer orderNumber;
	@Setter
	private List<String> categories;
}
