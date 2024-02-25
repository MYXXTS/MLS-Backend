package com.myxxts.mls.service.core;

import com.myxxts.mls.module.core.article.vo.ArticleConsoleInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleConsoleListVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewListVo;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ArticleServiceTests {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private ArticleService articleService;

    @Test
    void contextLoads() {
        assertThat(context).isNotNull();
    }

    @Test
    void findAllArticleForConsole() {
        List<String> tags = List.of("default tag 1");
        List<String> categories = List.of("default category");
        Map<String, Integer> sort = Map.of("createTime", 0);
        List<ArticleConsoleListVo> allArticleForConsole = articleService.findAllArticleForConsole(tags, categories, sort, 0, 10);
        System.out.println(allArticleForConsole);
        assertThat(allArticleForConsole).isNotNull();
    }

    @Test
    void findArticleByIdForConsole() {
        ObjectId id = new ObjectId("65d22105f353180faae7053e");
        ArticleConsoleInfoVo articleByIdForConsole = articleService.findArticleByIdForConsole(id);
        System.out.println(articleByIdForConsole);
        assertThat(articleByIdForConsole).isNotNull();
    }

    @Test
    void findArticleByIdForView() {
        ObjectId id = new ObjectId("65d22105f353180faae7053e");
        ArticleViewInfoVo articleByIdForView = articleService.findArticleByIdForView(id);
        System.out.println(articleByIdForView);
        assertThat(articleByIdForView).isNotNull();
    }

    @Test
    void findAllArticleForView() {
        List<String> tags = List.of("default tag 1");
        List<String> categories = List.of("default category");
        Map<String, Integer> sort = Map.of("createTime", 0);
        List<ArticleViewListVo> allArticleForView = articleService.findAllArticleForView(tags, categories, sort, 0, 10);
        System.out.println(allArticleForView);
        assertThat(allArticleForView).isNotNull();
    }
}
