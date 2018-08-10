package br.com.neoholding.oi.garcom.model.entity.menu;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@Document(collection = "Categories")
public class Category  implements Serializable
{
	@Id
	private String id;
	private String name;
	private Integer orderNumber;
	private List<String> items;
}
