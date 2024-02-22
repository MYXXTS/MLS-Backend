package com.myxxts.mls.module.core.article.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleConsoleInfoVoMetaData {
    private Boolean allowRss; // Article allow rss
    private Boolean allowComment; // Article allow comment
    private Boolean isTop; // Article is top
    private Integer expire; // Article expire status
    private LocalDateTime expireTime; // Article expire time
    private String copyright; // Article copyright
    private String articleStatus; // Article status
    private String copyrightInfo; // Article copyright information
}
