package com.myxxts.mls.module.core.category.vo;

import com.myxxts.mls.module.BaseModule;
import lombok.*;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CategoryViewListVo extends BaseModule {
        private ObjectId cid; // Article category id
        private CategoryViewListVo child; // Article category child
        private String name; // Article category name
        private String description; // Tag description
        private String route; // Article category route
}
