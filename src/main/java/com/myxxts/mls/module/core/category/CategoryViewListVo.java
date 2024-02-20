package com.myxxts.mls.module.core.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryViewListVo {
        private ObjectId acid; // Article category id
        private CategoryViewListVo child; // Article category child
        private String name; // Article category name
        private String description; // Tag description
        private String route; // Article category route
}
