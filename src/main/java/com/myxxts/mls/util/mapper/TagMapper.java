package com.myxxts.mls.util.mapper;

import com.myxxts.mls.module.core.tag.TagEntity;
import com.myxxts.mls.module.core.tag.vo.TagConsoleListVo;
import com.myxxts.mls.module.core.tag.vo.TagViewListVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagConsoleListVo toTagConsoleListVo(TagEntity tagEntity);

    List<TagConsoleListVo> toTagConsoleListVos(List<TagEntity> tagEntity);

    TagViewListVo toTagViewListVo(TagEntity tagEntity);

    List<TagViewListVo> toTagViewListVos(List<TagEntity> tagEntity);
}
