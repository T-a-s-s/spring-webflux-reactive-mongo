package br.com.neoholding.oi.garcom.model.entity.promotion;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Document(collection = "Promotions")
public abstract class Promotion implements Serializable
{
	@Id
	private String id;
    private String type;
	private Integer discount;
}
