package com.myxxts.mls.module.core.article.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleViewInfoVoMetaData {
    private Boolean allowComment; // Article allow comment
    private Integer expire; // Article expire status
    private LocalDateTime expireTime; // Article expire time
    private String copyright; // Article copyright
    private String copyrightInfo; // Article copyright information
}
