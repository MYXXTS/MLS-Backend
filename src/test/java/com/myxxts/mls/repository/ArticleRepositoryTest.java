package com.myxxts.mls.repository;

import com.myxxts.mls.module.entity.core.Article;
import com.myxxts.mls.module.entity.core.Category;
import com.myxxts.mls.module.entity.core.Tag;
import com.myxxts.mls.repository.core.ArticleRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void testAddArticle() {
        ObjectId user = new ObjectId();
        Category category = new Category(
                user,
                user,
                "default category",
                "this is the default category"
        );
        Tag tag1 = new Tag(
                user,
                user,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "default tag 1",
                "this is the default tag 1"
        );
        Tag tag2 = new Tag(
                user,
                user,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "default tag 2",
                "this is the default tag 2"
        );
        Article article = new Article(
                user,
                user,
                LocalDateTime.now(),
                LocalDateTime.now(),
                List.of(category),
                List.of(tag1, tag2),
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
        articleRepository.save(article);
    }
}
