package com.myxxts.mls.repository.core;

import com.myxxts.mls.module.core.article.ArticleEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<ArticleEntity, ObjectId> {

}
