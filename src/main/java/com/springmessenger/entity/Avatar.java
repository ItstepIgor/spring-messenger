package com.springmessenger.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.InputStream;


//todo возможно эта сущность не нужна в GridFS и Repository  так же
@Document(collection = "users")
@Data
public class Avatar {

    @Id
    private String id;

    private String title;

    private InputStream image;
}
