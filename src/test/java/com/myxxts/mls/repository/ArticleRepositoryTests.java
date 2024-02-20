package com.myxxts.mls.repository;

import com.myxxts.mls.module.core.article.ArticleEntity;
import com.myxxts.mls.module.core.category.CategoryEntity;
import com.myxxts.mls.module.core.tag.TagEntity;
import com.myxxts.mls.repository.core.ArticleRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ArticleRepositoryTests {
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void testAddArticle() {
        ObjectId user = new ObjectId();
        CategoryEntity category = new CategoryEntity(
                user,
                user,
                "default category",
                "this is the default category"
        );
        TagEntity tag1 = new TagEntity(
                user,
                user,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "default tag 1",
                "this is the default tag 1"
        );
        TagEntity tag2 = new TagEntity(
                user,
                user,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "default tag 2",
                "this is the default tag 2"
        );
        ArticleEntity article = new ArticleEntity(
                user,
                user,
                LocalDateTime.now(),
                LocalDateTime.now(),
                List.of(tag1, tag2),
                List.of(category),
                "default article",
                "this is the default article content",
                "this is the default article briefIntroduction",
                "https://img.example.com/default-article.jpg",
                "local test copyright",
                true,
                true,
                false,
                1,
                null,
                "100",
                "100",
                "none"
        );
        ArticleEntity save = articleRepository.save(article);
        System.out.println(save);
    }
}
