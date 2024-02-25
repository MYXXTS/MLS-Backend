package com.myxxts.mls.repository.core;

import com.myxxts.mls.module.core.category.CategoryEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<CategoryEntity, ObjectId> {
}
