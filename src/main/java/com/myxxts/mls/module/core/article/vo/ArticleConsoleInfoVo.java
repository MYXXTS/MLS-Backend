package com.myxxts.mls.module.core.article.vo;

import com.myxxts.mls.module.BaseModule;
import com.myxxts.mls.module.core.category.vo.CategoryConsoleListVo;
import com.myxxts.mls.module.core.tag.vo.TagConsoleListVo;
import lombok.*;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ArticleConsoleInfoVo extends BaseModule {
    private ObjectId aid; // Article id
    private List<TagConsoleListVo> tags; // Article tags
    private List<CategoryConsoleListVo> categories; // Article categories
    private String title; // Article title
    private String content; // The Article content
    private String briefIntro; // Article brief introduction
    private String AISummary; // Article summary
    private String route; // Article route
    private String coverImage; // Article cover image
    private String coverImageCopyRight; // Article cover image copyright information
    private Integer commentCount; // Article comment count
    private Integer viewCount; // Article view count
    private Integer likeCount; // Article like count
    private ArticleConsoleInfoVoMetaData metaData; // Article meta data
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ArticleConsoleInfoVoMetaData {
    private Boolean allowRss; // Article allow rss
    private Boolean allowComment; // Article allow comment
    private Boolean isTop; // Article is top
    private Integer expire; // Article expire status
    private LocalDateTime expireTime; // Article expire time
    private String copyright; // Article copyright
    private String articleStatus; // Article status
    private String copyrightInfo; // Article copyright information
}