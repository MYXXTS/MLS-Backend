package com.myxxts.mls.module.core.tag;

import com.myxxts.mls.module.BaseModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tag")
//@CompoundIndex(
//        name = "tag_index",
//        def = "{'name': 1, 'route': 1}",
//        unique = true,
//        background = true
//)
public class TagEntity extends BaseModule {
    @Id
    @Field(write = Field.Write.ALWAYS)
    private ObjectId atid = new ObjectId(); // Article tag id
    @Field(write = Field.Write.ALWAYS)
    private Integer articleCount = 0; // Tag article count
    @Field(write = Field.Write.ALWAYS)
    @Indexed(unique = true, background = true)
    private String name; // Tag name
    @Field(write = Field.Write.ALWAYS)
    private String description; // Tag description
    @Field(write = Field.Write.ALWAYS)
    private String route = name; // Tag route

    public TagEntity(ObjectId createBy, ObjectId updateBy, LocalDateTime createTime, LocalDateTime updateTime, String name, String description) {
        super(createBy, updateBy, createTime, updateTime);
        this.name = name;
        this.description = description;
    }
}
