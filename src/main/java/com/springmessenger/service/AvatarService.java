package com.springmessenger.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AvatarService {


//    private final AvatarRepository avatarRepository;

    private final GridFsTemplate gridFsTemplate;

    private final GridFsOperations operations;

    public String addAvatar(String title, MultipartFile file) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("type", "image");
        metaData.put("title", title);
        ObjectId id = gridFsTemplate.store(file.getInputStream(), title, file.getContentType(), metaData);
        return id.toString();
    }

    public GridFsResource getAvatar(String id) throws IllegalStateException {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
//        Avatar avatar = new Avatar();
//        avatar.setTitle(file.getMetadata().get("title").toString());
//        avatar.setImage(operations.getResource(file).getInputStream());
        return operations.getResource(file);
    }

    public void delete(String id) {
        gridFsTemplate.delete(new Query(Criteria.where("_id").is(id)));
    }
}