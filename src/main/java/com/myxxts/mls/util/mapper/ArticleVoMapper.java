package com.myxxts.mls.util.mapper;

import com.myxxts.mls.module.core.article.ArticleEntity;
import com.myxxts.mls.module.core.article.vo.ArticleConsoleInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleConsoleListVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewListVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, TagMapper.class})
public interface ArticleVoMapper {

    @Mapping(target = "isTop", source = "articleEntity.metaData.isTop")
    @Mapping(target = "articleStatus", source = "articleEntity.metaData.articleStatus")
    ArticleConsoleListVo toArticleConsoleListVo(ArticleEntity articleEntity);

    List<ArticleConsoleListVo> toArticleConsoleListVos(List<ArticleEntity> articleEntity);

    ArticleViewListVo toArticleViewListVo(ArticleEntity articleEntity);

    List<ArticleViewListVo> toArticleViewListVos(List<ArticleEntity> articleEntity);

    ArticleConsoleInfoVo toArticleConsoleInfoVo(ArticleEntity articleEntity);

    ArticleViewInfoVo toArticleViewInfoVo(ArticleEntity articleEntity);
}
