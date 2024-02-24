package com.myxxts.mls.repository.core;

import com.myxxts.mls.module.core.tag.TagEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<TagEntity, ObjectId> {
}
