package com.myxxts.mls.module.core.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleEntityMetaData {
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
