package com.myxxts.mls.module.core.article;

import com.myxxts.mls.module.BaseModule;
import com.myxxts.mls.module.core.category.CategoryConsoleListVo;
import com.myxxts.mls.module.core.tag.TagConsoleListVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleConsoleListVo extends BaseModule {
    private ObjectId aid; // Article id
    private List<TagConsoleListVo> tags; // Article tags
    private List<CategoryConsoleListVo> categories; // Article categories
    private String title; // Article title
    private Integer commentCount; // Article comment count
    private Integer viewCount; // Article view count
    private Integer likeCount; // Article like count
    private Boolean isTop; // Article is top
    private String articleStatus; // Article status
}

