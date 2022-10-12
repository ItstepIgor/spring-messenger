package com.springmessenger.repository;

import com.springmessenger.entity.Avatar;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvatarRepository extends MongoRepository<Avatar, String> {
}
