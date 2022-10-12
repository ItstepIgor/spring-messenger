package com.springmessenger.service;

import com.springmessenger.entity.Avatar;
import com.springmessenger.repository.AvatarRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AvatarService {

    private final AvatarRepository avatarRepository;

    public AvatarService(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }


    public String addAvatar(MultipartFile file) throws IOException {
        Avatar avatar = new Avatar();
        avatar.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));

        avatar = avatarRepository.insert(avatar);

        return avatar.getId();
    }

    public Avatar getAvatar(String id) {
        return avatarRepository.findById(id).get();
    }


//    private final GridFsTemplate gridFsTemplate;
//
//    private final GridFsOperations operations;
//
//    public AvatarService(AvatarRepository avatarRepository, GridFsTemplate gridFsTemplate, GridFsOperations operations) {
//        this.avatarRepository = avatarRepository;
//        this.gridFsTemplate = gridFsTemplate;
//        this.operations = operations;
//    }
//
//
//    public String addAvatar(MultipartFile file) throws IOException {
//        DBObject metaData = new BasicDBObject();
//        metaData.put("type", "image");
//        ObjectId id = gridFsTemplate.store(
//                file.getInputStream(), file.getName(), file.getContentType(), metaData);
//        return id.toString();
//    }
//
//    public Avatar getAvatar(String id) throws IllegalStateException, IOException {
//        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
//        Avatar avatar = new Avatar();
//        avatar.setStream(operations.getResource(file).getInputStream());
//        return avatar;
//
//    }
}