package com.myxxts.mls.repository.core;

import com.myxxts.mls.module.core.article.ArticleEntity;
import jakarta.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ArticleRepository extends MongoRepository<ArticleEntity, ObjectId> {
    @Query(value = "{'tags.name': { $in: ?0 }, 'categories.name': { $in: ?1 }}")
    List<ArticleEntity> findAllByTagsAndCategories(@NotNull List<String> tags, @NotNull List<String> categories, PageRequest pageRequest);

    @Query(value = "{'tags.name': { $in: ?0 }}")
    List<ArticleEntity> findAllByTags(@NotNull List<String> tags, PageRequest pageRequest);

    @Query(value = "{ 'categories.name': { $in: ?0 }}")
    List<ArticleEntity> findAllByCategories(@NotNull List<String> categories, PageRequest pageRequest);

}
