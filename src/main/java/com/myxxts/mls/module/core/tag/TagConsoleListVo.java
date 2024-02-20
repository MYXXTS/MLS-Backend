package com.myxxts.mls.module.core.tag;

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
public class TagConsoleListVo extends BaseModule {
    private ObjectId atid; // Article tag id
    private Integer articleCount; // Tag article count
    private String name; // Tag name
    private String description; // Tag description
}
