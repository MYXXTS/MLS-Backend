package com.myxxts.mls.repository.core;

import com.myxxts.mls.module.core.article.ArticleEntity;
import com.myxxts.mls.module.core.article.vo.ArticleConsoleListVo;
import com.myxxts.mls.module.core.category.CategoryEntity;
import com.myxxts.mls.module.core.tag.TagEntity;
import com.myxxts.mls.util.mapper.ArticleVoMapper;
import net.minidev.json.JSONArray;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ArticleRepositoryTests {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleVoMapper articleVoMapper;
    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertThat(context).isNotNull();
    }

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
                "default tag 1",
                "this is the default tag 1"
        );
        TagEntity tag2 = new TagEntity(
                user,
                user,
                "default tag 2",
                "this is the default tag 2"
        );
        ArticleEntity article = new ArticleEntity(
                user,
                user,
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

    @Test
    void testFindAllByTagsAndCategories() {
        Sort sort = Sort.by(Sort.Order.desc("updateTime"), Sort.Order.desc("createTime"));
        PageRequest pageRequest = PageRequest.of(0, 10, sort);
        List<String> tags = List.of("default tag 1");
        List<String> categories = List.of("default category");

        List<ArticleEntity> all = articleRepository.findAllByTagsAndCategories(tags, categories, pageRequest);
        List<ArticleConsoleListVo> articleConsoleListVos = articleVoMapper.toArticleConsoleListVos(all);
        System.out.println(JSONArray.toJSONString(articleConsoleListVos));
    }
    @Test
    void testFindAllByTags() {
        Sort sort = Sort.by(Sort.Order.desc("updateTime"), Sort.Order.desc("createTime"));
        PageRequest pageRequest = PageRequest.of(0, 10, sort);
        List<String> tags = List.of("default tag 1");

        List<ArticleEntity> all = articleRepository.findAllByTags(tags, pageRequest);
        List<ArticleConsoleListVo> articleConsoleListVos = articleVoMapper.toArticleConsoleListVos(all);
        System.out.println(JSONArray.toJSONString(articleConsoleListVos));
    }
    @Test
    void testFindAllByCategories() {
        Sort sort = Sort.by(Sort.Order.desc("updateTime"), Sort.Order.desc("createTime"));
        PageRequest pageRequest = PageRequest.of(0, 10, sort);
        List<String> categories = List.of("default category");

        List<ArticleEntity> all = articleRepository.findAllByCategories( categories, pageRequest);
        List<ArticleConsoleListVo> articleConsoleListVos = articleVoMapper.toArticleConsoleListVos(all);
        System.out.println(JSONArray.toJSONString(articleConsoleListVos));
    }
    @Test
    void testFindAll() {
        Sort sort = Sort.by(Sort.Order.desc("updateTime"), Sort.Order.desc("createTime"));
        PageRequest pageRequest = PageRequest.of(0, 10, sort);


        List<ArticleEntity> all = articleRepository.findAll(pageRequest).getContent();
        List<ArticleConsoleListVo> articleConsoleListVos = articleVoMapper.toArticleConsoleListVos(all);
        System.out.println(JSONArray.toJSONString(articleConsoleListVos));
    }
}
