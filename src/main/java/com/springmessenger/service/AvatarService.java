package com.springmessenger.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.springmessenger.entity.Avatar;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AvatarService {
    private static final String GRID_FS_FILE_ID = "_id";
    private static final String TITLE = "title";
    private static final String CONTENT_TYPE = "_contentType";

    private final GridFsOperations operations;
    private final UsersService usersService;

    @SneakyThrows
    public String addAvatar(String title, MultipartFile file) {
        DBObject metaData = new BasicDBObject();
        metaData.put(TITLE, title);
        ObjectId id = operations.store(file.getInputStream(), title, file.getContentType(), metaData);
        return id.toString();
    }

    @SneakyThrows
    public Avatar getAvatar(Long id) {
        // TODO "_id" - constant
        // TODO null checks (idea warnings)
        // TODO save content type to metadata for put it to get method header
        // TODO return object with file data from service, replace GridFsResource with InputStream
        //  return value from controller - ResponseEntity<InputStreamResource>

        GridFSFile file = operations.findOne(new Query(Criteria.where(GRID_FS_FILE_ID)
                .is(usersService.findById(id).getAvatarId())));
        Avatar avatar = new Avatar();
        avatar.setId(String.valueOf(Objects.requireNonNull(file).getObjectId()));
        avatar.setTitle(Objects.requireNonNull(file.getMetadata()).get(TITLE).toString());
        avatar.setContentType(file.getMetadata().get(CONTENT_TYPE).toString());
        avatar.setImage(operations.getResource(file).getInputStream());
        return avatar;
    }

    public void delete(String id) {
        operations.delete(new Query(Criteria.where(GRID_FS_FILE_ID).is(id)));
    }
}