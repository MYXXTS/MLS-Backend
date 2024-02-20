package com.myxxts.mls.module.core.tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagViewListVo {
    private ObjectId atid; // Article tag id
    private String name; // Tag name
    private String description; // Tag description
    private String route; // Tag route
}