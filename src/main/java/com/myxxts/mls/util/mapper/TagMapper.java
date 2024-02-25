package com.myxxts.mls.util.mapper;

import com.myxxts.mls.module.core.tag.TagEntity;
import com.myxxts.mls.module.core.tag.vo.TagConsoleListVo;
import com.myxxts.mls.module.core.tag.vo.TagViewListVo;
import com.myxxts.mls.util.UtilMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UtilMapper.class})
public interface TagMapper {
    @Mapping(target = "tid", qualifiedByName = "objectIdToString")
    TagConsoleListVo toTagConsoleListVo(TagEntity tagEntity);

    List<TagConsoleListVo> toTagConsoleListVos(List<TagEntity> tagEntity);

    @Mapping(target = "tid", qualifiedByName = "objectIdToString")
    TagViewListVo toTagViewListVo(TagEntity tagEntity);

    List<TagViewListVo> toTagViewListVos(List<TagEntity> tagEntity);
}
