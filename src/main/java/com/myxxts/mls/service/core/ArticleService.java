package com.myxxts.mls.service.core;

import com.myxxts.mls.module.core.article.vo.ArticleConsoleInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleConsoleListVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewListVo;
import jakarta.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

@Validated
public interface ArticleService {
    // Console panel
    List<ArticleConsoleListVo> findAllArticleForConsole( List<String> tags, List<String> categories, Map<String, Integer> sort, Integer page, Integer size);

    ArticleConsoleInfoVo findArticleByIdForConsole(@NotNull ObjectId id);

    // Frontend view
    ArticleViewInfoVo findArticleByIdForView(@NotNull ObjectId id);

    List<ArticleViewListVo> findAllArticleForView( List<String> tags,  List<String> categories, Map<String, Integer> sort, Integer page, Integer size);

}
