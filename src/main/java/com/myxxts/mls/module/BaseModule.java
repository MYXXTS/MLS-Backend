package com.myxxts.mls.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseModule {
    //    @DocumentReference(lookup = "{'uid' : ?#{#target} }", collection = "User")
    protected ObjectId createBy; // The content is created by a user
    //    @DocumentReference(lookup = "{'uid' : ?#{#target} }", collection = "User")
    protected ObjectId updateBy; // The content is updated by a user
    protected LocalDateTime createTime = LocalDateTime.now(); // The content create time
    protected LocalDateTime updateTime = LocalDateTime.now(); // The content update time

    public BaseModule(ObjectId updateBy, LocalDateTime updateTime) {
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public BaseModule(ObjectId createBy, ObjectId updateBy) {
        this.createBy = createBy;
        this.updateBy = updateBy;
    }

}
