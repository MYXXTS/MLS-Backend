package com.myxxts.mls.module.core.article.vo;

import com.myxxts.mls.module.BaseModule;
import com.myxxts.mls.module.core.category.vo.CategoryConsoleListVo;
import com.myxxts.mls.module.core.tag.vo.TagConsoleListVo;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ArticleConsoleListVo extends BaseModule {
    private String aid; // Article id
    private List<TagConsoleListVo> tags; // Article tags
    private List<CategoryConsoleListVo> categories; // Article categories
    private String title; // Article title
    private Integer commentCount; // Article comment count
    private Integer viewCount; // Article view count
    private Integer likeCount; // Article like count
    private Boolean isTop; // Article is top
    private String articleStatus; // Article status
}

