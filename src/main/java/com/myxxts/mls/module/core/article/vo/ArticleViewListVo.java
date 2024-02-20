package com.myxxts.mls.module.core.article.vo;

import com.myxxts.mls.module.BaseModule;
import com.myxxts.mls.module.core.category.vo.CategoryViewListVo;
import com.myxxts.mls.module.core.tag.vo.TagViewListVo;
import lombok.*;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ArticleViewListVo extends BaseModule {
    private ObjectId aid; // Article id
    private List<TagViewListVo> tags; // Tag Info list
    private List<CategoryViewListVo> categories; // Category Info
    private String title; // Article title
    private String briefIntro; // Article brief introduction
    private String route; // Article route
    private Integer commentCount; // Article comment count
    private Integer viewCount; // Article view count
    private Integer likeCount; // Article like count
}
