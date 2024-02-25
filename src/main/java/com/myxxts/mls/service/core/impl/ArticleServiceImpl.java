package com.myxxts.mls.service.core.impl;

import com.myxxts.mls.module.core.article.ArticleEntity;
import com.myxxts.mls.module.core.article.vo.ArticleConsoleInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleConsoleListVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewInfoVo;
import com.myxxts.mls.module.core.article.vo.ArticleViewListVo;
import com.myxxts.mls.repository.core.ArticleRepository;
import com.myxxts.mls.service.core.ArticleService;
import com.myxxts.mls.util.mapper.ArticleVoMapper;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleVoMapper articleVoMapper;

    public ArticleServiceImpl(ArticleRepository articleRepository, ArticleVoMapper articleVoMapper) {
        this.articleRepository = articleRepository;
        this.articleVoMapper = articleVoMapper;
    }

    // Console panel

    /**
     * get all articles for console
     *
     * @param tags       tags name
     * @param categories categories name
     * @param sort       sort by
     * @param page       page number
     * @param size       page size
     * @return List<ArticleConsoleListVo>
     */
    @Override
    public List<ArticleConsoleListVo> findAllArticleForConsole(List<String> tags, List<String> categories, Map<String, Integer> sort, Integer page, Integer size) {
        PageRequest pageRequest = createPageRequest(sort, page, size);
        if (tags.isEmpty() && categories.isEmpty()) {
            List<ArticleEntity> all = articleRepository.findAll(pageRequest).getContent();
            return articleVoMapper.toArticleConsoleListVos(all);
        }
        if (tags.isEmpty()) {
            List<ArticleEntity> all = articleRepository.findAllByCategories(categories, pageRequest);
            return articleVoMapper.toArticleConsoleListVos(all);
        }
        if (categories.isEmpty()) {
            List<ArticleEntity> all = articleRepository.findAllByTags(tags, pageRequest);
            return articleVoMapper.toArticleConsoleListVos(all);
        }
        List<ArticleEntity> all = articleRepository.findAllByTagsAndCategories(tags, categories, pageRequest);
        return articleVoMapper.toArticleConsoleListVos(all);
    }

    /**
     * get article information by article ObjectId for console
     *
     * @param id article ObjectId
     * @return ArticleConsoleInfoVo
     */
    @Override
    public ArticleConsoleInfoVo findArticleByIdForConsole(ObjectId id) {
        Optional<ArticleEntity> articleEntity = articleRepository.findById(id);
        return articleVoMapper.toArticleConsoleInfoVo(articleEntity.orElse(null));
    }

    // Frontend view

    /**
     * get article information by article ObjectId for view
     *
     * @param id article ObjectId
     * @return ArticleViewInfoVo
     */
    @Override
    public ArticleViewInfoVo findArticleByIdForView(ObjectId id) {
        Optional<ArticleEntity> articleEntity = articleRepository.findById(id);
        return articleVoMapper.toArticleViewInfoVo(articleEntity.orElse(null));
    }

    /**
     * get articles by page for view
     *
     * @param tags       tags name
     * @param categories categories name
     * @param sort       sort by
     * @param page       page number
     * @param size       page size
     * @return List<ArticleViewListVo>
     */
    @Override
    public List<ArticleViewListVo> findAllArticleForView(List<String> tags, List<String> categories, Map<String, Integer> sort, Integer page, Integer size) {
        PageRequest pageRequest = createPageRequest(sort, page, size);
        if (tags.isEmpty() && categories.isEmpty()) {
            List<ArticleEntity> all = articleRepository.findAll(pageRequest).getContent();
            return articleVoMapper.toArticleViewListVos(all);
        }
        if (tags.isEmpty()) {
            List<ArticleEntity> all = articleRepository.findAllByCategories(categories, pageRequest);
            return articleVoMapper.toArticleViewListVos(all);
        }
        if (categories.isEmpty()) {
            List<ArticleEntity> all = articleRepository.findAllByTags(tags, pageRequest);
            return articleVoMapper.toArticleViewListVos(all);
        }
        List<ArticleEntity> all = articleRepository.findAllByTagsAndCategories(tags, categories, pageRequest);
        return articleVoMapper.toArticleViewListVos(all);
    }

    /**
     * create PageRequest
     *
     * @param sort sort by
     * @param page page number
     * @param size page size
     * @return PageRequest
     */
    private PageRequest createPageRequest(Map<String, Integer> sort, Integer page, Integer size) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (size == null || size < 0) {
            size = 10;
        }
        PageRequest pageRequest = PageRequest.of(page, size);
        if (sort.isEmpty()) {
            pageRequest.withSort(
                    Sort.by(Sort.Order.desc("updateTime"), Sort.Order.desc("createTime"))
            );
        } else {
            sort.forEach((k, v) -> {
                        if (v == 1) {
                            pageRequest.withSort(Sort.by(Sort.Order.asc(k)));
                        } else {
                            pageRequest.withSort(Sort.by(Sort.Order.desc(k)));
                        }
                    }
            );
        }
        return pageRequest;
    }

}
