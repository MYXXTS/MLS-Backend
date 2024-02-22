package com.myxxts.mls.module.core.article;

import com.myxxts.mls.module.BaseModule;
import com.myxxts.mls.module.core.category.CategoryEntity;
import com.myxxts.mls.module.core.tag.TagEntity;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Document(collection = "article")
public class ArticleEntity extends BaseModule {
    @Id
    private ObjectId aid = new ObjectId(); // Article id
    @Field(write = Field.Write.ALWAYS)
    private List<TagEntity> tags; // Tag Info list
    @Field(write = Field.Write.ALWAYS)
    private List<CategoryEntity> categories; // Category Info
    @NotNull(message = "Article title cannot empty")
    @Field(write = Field.Write.ALWAYS)
    private String title; // Article title
    @NotNull(message = "The content cannot be null")
    @Field(write = Field.Write.ALWAYS)
    private String content; // The Article content
    @Field(write = Field.Write.ALWAYS)
    private String briefIntro; // Article brief introduction, if brief is null, truncate the specified character of content as the brief intro
    @Field(write = Field.Write.ALWAYS)
    private String AISummary = ""; // Article summary
    @Field(write = Field.Write.ALWAYS)
    private String route = aid.toString(); // Article route, if route is null, then use aid as route
    @Field(write = Field.Write.ALWAYS)
    private String coverImage; // Article cover image
    @Field(write = Field.Write.ALWAYS)
    private String coverImageCopyRight; // Article cover image copyright information
    @Field(write = Field.Write.ALWAYS)
    private Integer commentCount = 0; // Article comment count
    @Field(write = Field.Write.ALWAYS)
    private Integer viewCount = 0; // Article view count
    @Field(write = Field.Write.ALWAYS)
    private Integer likeCount = 0; // Article like count
    @Field(write = Field.Write.ALWAYS)
    private ArticleEntityMetaData metaData; // Article meta data

    public ArticleEntity(ObjectId createBy, ObjectId updateBy, List<TagEntity> tags, List<CategoryEntity> categories, String title, String content, String briefIntro, String coverImage, String coverImageCopyRight, Boolean allowRss, Boolean allowComment, Boolean isTop, Integer expire, LocalDateTime expireTime, String copyright, String articleStatus, String copyrightInfo) {
        super(createBy, updateBy);
        this.tags = tags;
        this.categories = categories;
        this.title = title;
        this.content = content;
        this.briefIntro = briefIntro;
        this.coverImage = coverImage;
        this.coverImageCopyRight = coverImageCopyRight;
        this.metaData = new ArticleEntityMetaData(allowRss, allowComment, isTop, expire, expireTime, copyright, articleStatus, copyrightInfo);
    }
}