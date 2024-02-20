package com.myxxts.mls.module.core.article;

import com.myxxts.mls.module.BaseModule;
import com.myxxts.mls.module.core.category.CategoryEntity;
import com.myxxts.mls.module.core.tag.TagEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "article")
public class ArticleEntity extends BaseModule {
    @Id
    private ObjectId aid = new ObjectId(); // Article id

    @Field(write = Field.Write.ALWAYS)
//    @DocumentReference(collection = "tag",
//            lookup = "{ " +
//                    "'atid' : ?#{#target.atid}," +
//                    "'name' : ?#{#target.name}," +
//                    "'route' : ?#{#target.route} " +
//                    "}")
    private List<TagEntity> tags; // Tag Info list

    @Field(write = Field.Write.ALWAYS)
//    @DocumentReference(collection = "category",
//            lookup = "{ " +
//                    "'acid' : ?#{#target.acid}," +
//                    "'name' : ?#{#target.name}," +
//                    "'route' : ?#{#target.route} " +
//                    "}")
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

    public ArticleEntity(ObjectId createBy, ObjectId updateBy, LocalDateTime createTime, LocalDateTime updateTime, List<TagEntity> tags, List<CategoryEntity> categories, String title, String content, String briefIntro, String coverImage, String coverImageCopyRight, Boolean allowRss, Boolean allowComment, Boolean isTop, Integer expire, LocalDateTime expireTime, String copyright, String articleStatus, String copyrightInfo) {
        super(createBy, updateBy, createTime, updateTime);
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

@Data
@AllArgsConstructor
@NoArgsConstructor
class ArticleEntityMetaData {
    @Field(write = Field.Write.ALWAYS)
    private Boolean allowRss; // Article allow rss
    @Field(write = Field.Write.ALWAYS)
    private Boolean allowComment; // Article allow comment
    @Field(write = Field.Write.ALWAYS)
    private Boolean isTop; // Article is top
    @Field(write = Field.Write.ALWAYS)
    private Integer expire; // Article expire status, if 1, then expire, if 0, then not expire, if 2, then not set expire
    @Field(write = Field.Write.ALWAYS)
    private LocalDateTime expireTime; // Article expire time (if expire is 1), if expire is 2, then expire time is null
    // Article Copyright Code Reference:
    // 100: CC BY 4.0,
    // 130: CC BY-SA 4.0,
    // 120: CC BY-ND 4.0,
    // 110: CC BY-NC 4.0,
    // 111: CC BY-NC-SA 4.0,
    // 112: CC BY-NC-ND 4.0,
    // 200：not allow reprint
    // 202: reprint from other website or from internet
    @Field(write = Field.Write.ALWAYS)
    private String copyright; // Article copyright
    // Article Status Code Reference:
    // Article Status Code consists of three parts.
    // first part is the article status, 0 means not published, 1 means published, 2 means deleted.
    // second part is the article visibility, 0 means public, 1 meas hidden, 2 means password protected, 3 means private.
    // third part is the article detailed status, 0 means no detailed status, 1 means featured, 2 means archived.
    // 000 Draft: The author is currently editing, and the article has not been published.
    // 100 Published: The article has been reviewed and officially published on the blog, available for readers to read.
    // 102 Archived: The article may be outdated or no longer relevant, but is still accessible. Typically categorized by time or topic.
    // 110 Hidden: The article is not visible to the public, possibly temporarily hidden by the author.
    // 120 Password Protected: The article is protected by a password, accessible only to those who know the password.
    // 101 Featured: The article is marked as highly recommended, often prominently displayed on the homepage or in a special section.
    // 130 Private: The article is not visible to the public; only the author or authorized users can access it.
    // 200 Deleted: The article has been deleted by the author or administrator and is no longer visible to the public.
    @Field(write = Field.Write.ALWAYS)
    private String articleStatus; // Article status
    @Field(write = Field.Write.ALWAYS)
    private String copyrightInfo; // If copyright is 200 or 202, save copyright information note

}