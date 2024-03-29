package com.myxxts.mls.module.core.category.vo;

import com.myxxts.mls.module.BaseModule;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CategoryConsoleListVo extends BaseModule {
    private String cid; // Article category id
    private CategoryConsoleListVo child; // Article category child
    private Integer articleCount; // Article category article count
    private String name; // Article category name
    private String description; // Article category description
}
