package com.springmessenger.service;

import com.springmessenger.entity.AvatarOld;
import com.springmessenger.repository.AvatarOldRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AvatarOldService {

    private final AvatarOldRepository avatarOldRepository;

    public AvatarOldService(AvatarOldRepository avatarOldRepository) {
        this.avatarOldRepository = avatarOldRepository;
    }


    public String addAvatarOld(String title, MultipartFile file) throws IOException {
        AvatarOld avatarOld = new AvatarOld();
        avatarOld.setTitle(title);
        avatarOld.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));

        avatarOld = avatarOldRepository.insert(avatarOld);

        return avatarOld.getId();
    }

    public AvatarOld getAvatarOld(String id) {
        return avatarOldRepository.findById(id).orElse(null);
    }

    public void delete(String id) {
        avatarOldRepository.deleteById(id);
    }
}