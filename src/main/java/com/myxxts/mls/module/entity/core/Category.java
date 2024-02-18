package com.myxxts.mls.module.entity.core;

import com.myxxts.mls.module.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "article_category")
public class Category extends BaseEntity {
    @Id
    private ObjectId acid = new ObjectId(); // Article category id
    @Field(write = Field.Write.NON_NULL)
    private Category child; // Article category child
    @Field(write = Field.Write.ALWAYS)
    private Integer articleCount = 0; // Article category article count
    @Field(write = Field.Write.ALWAYS)
    private String name; // Article category name
    @Field(write = Field.Write.ALWAYS)
    private String description; // Article category description
    @Field(write = Field.Write.ALWAYS)
    private String route = name; // Article category route

    public Category(ObjectId createBy, ObjectId updateBy, String name, String description) {
        super(createBy, updateBy);
        this.name = name;
        this.description = description;
    }
}
