package com.myxxts.mls.util;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UtilMapper {
    @Named("objectIdToString")
    static String objectIdToString(ObjectId objectId) {
        return objectId.toHexString();
    }
}
