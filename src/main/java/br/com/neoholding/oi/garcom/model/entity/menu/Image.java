package br.com.neoholding.oi.garcom.model.entity.menu;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Images")
public class Image
{
    @Id
    private byte[] image;
    private String imageContentType;
}
