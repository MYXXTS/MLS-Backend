package com.myxxts.mls.util.mapper;

import com.myxxts.mls.module.core.article.ArticleEntity;
import com.myxxts.mls.module.core.article.vo.ArticleConsoleInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleConsoleListVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewListVo;
import com.myxxts.mls.util.UtilMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, TagMapper.class, UtilMapper.class})
public interface ArticleVoMapper {

    @Mapping(target = "isTop", source = "articleEntity.metaData.isTop")
    @Mapping(target = "articleStatus", source = "articleEntity.metaData.articleStatus")
    @Mapping(target = "aid", qualifiedByName = "objectIdToString")
    ArticleConsoleListVo toArticleConsoleListVo(ArticleEntity articleEntity);

    List<ArticleConsoleListVo> toArticleConsoleListVos(List<ArticleEntity> articleEntity);

    @Mapping(target = "aid", qualifiedByName = "objectIdToString")
    ArticleViewListVo toArticleViewListVo(ArticleEntity articleEntity);

    List<ArticleViewListVo> toArticleViewListVos(List<ArticleEntity> articleEntity);

    @Mapping(target = "aid", qualifiedByName = "objectIdToString")
    ArticleConsoleInfoVo toArticleConsoleInfoVo(ArticleEntity articleEntity);

    @Mapping(target = "aid", qualifiedByName = "objectIdToString")
    ArticleViewInfoVo toArticleViewInfoVo(ArticleEntity articleEntity);
}
