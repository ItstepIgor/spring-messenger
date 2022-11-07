package com.avatarservice.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.InputStream;

@Document(collection = "users")
@Data
public class Avatar {

    @Id
    private String id;

    private String title;

    private String contentType;

    private InputStream image;
}
