package com.myxxts.mls.module.core.article;

import com.myxxts.mls.module.BaseModule;
import com.myxxts.mls.module.core.category.CategoryViewListVo;
import com.myxxts.mls.module.core.tag.TagViewListVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleViewInfoVo extends BaseModule {
    private ObjectId aid; // Article id
    private List<TagViewListVo> tags; // Tag Info list
    private List<CategoryViewListVo> categories; // Category Info
    private String title; // Article title
    private String content; // The Article content
    private String AISummary; // Article summary
    private String coverImage; // Article cover image
    private String coverImageCopyRight; // Article cover image copyright information
    private Integer commentCount; // Article comment count
    private Integer viewCount; // Article view count
    private Integer likeCount; // Article like count
    private ArticleViewInfoVoMetaData metaData; // Article meta data
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ArticleViewInfoVoMetaData {
    private Integer allowComment; // Article allow comment
    private Integer expire; // Article expire status
    private LocalDateTime expireTime; // Article expire time
    private String copyright; // Article copyright
    private String copyrightInfo; // Article copyright information
}