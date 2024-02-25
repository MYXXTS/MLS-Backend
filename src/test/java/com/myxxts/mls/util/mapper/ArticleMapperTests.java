package com.myxxts.mls.util.mapper;

import com.myxxts.mls.module.core.article.ArticleEntity;
import com.myxxts.mls.module.core.article.vo.ArticleConsoleInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleConsoleListVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewListVo;
import com.myxxts.mls.module.core.category.CategoryEntity;
import com.myxxts.mls.module.core.tag.TagEntity;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ArticleMapperTests {
    @Autowired
    private ArticleVoMapper articleVoMapper;
    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertThat(context).isNotNull();
    }

    @Test
    void testArticleEntityToVoMapper() {
        ObjectId userId = new ObjectId();
        CategoryEntity childCategory = new CategoryEntity(
                userId,
                userId,
                "test child category",
                "test child category description"
        );
        CategoryEntity categoryEntity = new CategoryEntity(
                userId,
                userId,
                childCategory,
                "test article category",
                "test article category description"
        );
        TagEntity tagEntity = new TagEntity(
                userId,
                userId,
                "test tag",
                "test tag description"
        );
        TagEntity tagEntity1 = new TagEntity(
                userId,
                userId,
                "test tag 1",
                "test tag 1 description"
        );
        ArticleEntity articleEntity = new ArticleEntity(
                userId,
                userId,
                List.of(tagEntity, tagEntity1),
                List.of(categoryEntity),
                "test article",
                "test article content",
                "test article briefIntro",
                "https://test.com/test.jpg",
                "test cover image copyright",
                true,
                true,
                false,
                0,
                null,
                "100",
                "100",
                ""
        );

        System.out.println(articleEntity);
        System.out.println("======================================================");

        ArticleConsoleListVo articleConsoleListVo = articleVoMapper.toArticleConsoleListVo(articleEntity);
        System.out.println(articleConsoleListVo);
        System.out.println("======================================================");

        ArticleViewListVo articleViewListVo = articleVoMapper.toArticleViewListVo(articleEntity);
        System.out.println(articleViewListVo);
        System.out.println("======================================================");

        List<ArticleConsoleListVo> articleConsoleListVos = articleVoMapper.toArticleConsoleListVos(List.of(articleEntity));
        System.out.println(articleConsoleListVos);
        System.out.println("======================================================");

        List<ArticleViewListVo> articleViewListVos = articleVoMapper.toArticleViewListVos(List.of(articleEntity));
        System.out.println(articleViewListVos);
        System.out.println("======================================================");

        ArticleConsoleInfoVo articleConsoleInfoVo = articleVoMapper.toArticleConsoleInfoVo(articleEntity);
        System.out.println(articleConsoleInfoVo);
        System.out.println("======================================================");

        ArticleViewInfoVo articleViewInfoVo = articleVoMapper.toArticleViewInfoVo(articleEntity);
        System.out.println(articleViewInfoVo);
    }
}
