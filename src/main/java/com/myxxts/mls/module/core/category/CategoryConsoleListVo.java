package com.myxxts.mls.module.core.category;

import com.myxxts.mls.module.BaseModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CategoryConsoleListVo extends BaseModule {
    private ObjectId acid; // Article category id
    private CategoryEntity child; // Article category child
    private Integer articleCount; // Article category article count
    private String name; // Article category name
    private String description; // Article category description
}
