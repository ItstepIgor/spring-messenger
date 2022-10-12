package com.springmessenger.entity;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "users")
@Data
public class Avatar {
    @Id
    private String id;

    private Binary image;
}
