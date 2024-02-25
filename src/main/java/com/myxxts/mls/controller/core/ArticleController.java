package com.myxxts.mls.controller.core;

import com.myxxts.mls.module.ResponseResult;
import com.myxxts.mls.module.core.article.vo.ArticleConsoleInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleConsoleListVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewListVo;
import com.myxxts.mls.service.core.ArticleService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController("/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/console/list")
    public ResponseResult<List<ArticleConsoleListVo>> findAllArticleForConsole(String[] tags, String[] categories, Map<String, Integer> sort, Integer page, Integer size) {
        List<ArticleConsoleListVo> articleConsoleListVos = articleService.findAllArticleForConsole(Arrays.asList(tags), Arrays.asList(categories), sort, page, size);
        return ResponseResult.success(articleConsoleListVos);
    }

    @GetMapping("/console/{id}")
    public ResponseResult<ArticleConsoleInfoVo> findArticleByIdForConsole(@PathVariable String id) {
        ObjectId objectId = new ObjectId(id);
        ArticleConsoleInfoVo articleConsoleInfoVo = articleService.findArticleByIdForConsole(objectId);
        return ResponseResult.success(articleConsoleInfoVo);
    }

    @GetMapping("/view/{id}")
    public ResponseResult<ArticleViewInfoVo> findArticleByIdForView(@PathVariable String id) {
        ObjectId objectId = new ObjectId(id);
        ArticleViewInfoVo articleViewInfoVo = articleService.findArticleByIdForView(objectId);
        return ResponseResult.success(articleViewInfoVo);
    }

    @GetMapping("/view/list")
    public ResponseResult<List<ArticleViewListVo>> findAllArticleForView(String[] tags, String[] categories, Map<String, Integer> sort, Integer page, Integer size) {
        List<ArticleViewListVo> articleConsoleListVos = articleService.findAllArticleForView(Arrays.asList(tags), Arrays.asList(categories), sort, page, size);
        return ResponseResult.success(articleConsoleListVos);
    }
}
