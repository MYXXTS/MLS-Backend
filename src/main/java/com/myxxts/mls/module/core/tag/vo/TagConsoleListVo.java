package com.myxxts.mls.module.core.tag.vo;

import com.myxxts.mls.module.BaseModule;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TagConsoleListVo extends BaseModule {
    private String tid; // Article tag id
    private Integer articleCount; // Tag article count
    private String name; // Tag name
    private String description; // Tag description
}
