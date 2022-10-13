package com.springmessenger.repository;

import com.springmessenger.entity.AvatarOld;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvatarOldRepository extends MongoRepository<AvatarOld, String> {
}
