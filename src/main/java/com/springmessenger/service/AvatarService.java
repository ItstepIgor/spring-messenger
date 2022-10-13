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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AvatarService {

    private final GridFsOperations operations;

    public String addAvatar(String title, MultipartFile file) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("type", "image");
        metaData.put("title", title);
        ObjectId id = operations.store(file.getInputStream(), title, file.getContentType(), metaData);
        return id.toString();
    }

    public GridFsResource getAvatar(String id) throws IllegalStateException {
        // TODO "_id" - constant
        // TODO null checks (idea warnings)
        // TODO save content type to metadata for put it to get method header
        // TODO return object with file data from service, replace GridFsResource with InputStream
        //  return value from controller - ResponseEntity<InputStreamResource>

//        Avatar avatar = new Avatar();
//        avatar.setTitle(file.getMetadata().get("title").toString());
//        avatar.setImage(operations.getResource(file).getInputStream());
        GridFSFile file = operations.findOne(new Query(Criteria.where("_id").is(id)));
        return operations.getResource(file);
    }

    public void delete(String id) {
        operations.delete(new Query(Criteria.where("_id").is(id)));
    }
}