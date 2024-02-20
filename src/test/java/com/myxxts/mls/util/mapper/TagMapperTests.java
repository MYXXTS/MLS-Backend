package com.myxxts.mls.util.mapper;

import com.myxxts.mls.module.core.tag.TagEntity;
import com.myxxts.mls.module.core.tag.vo.TagConsoleListVo;
import com.myxxts.mls.module.core.tag.vo.TagViewListVo;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TagMapperTests {
    @Autowired
    private TagMapper tagMapper;
    @Test
    void testTagEntityToVoMapper() {
        ObjectId userId = new ObjectId();
        TagEntity tagEntity = new TagEntity(
                userId,
                userId,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "test tag",
                "test tag description"
        );
        TagEntity tagEntity1 = new TagEntity(
                userId,
                userId,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "test tag 1",
                "test tag description 1"
        );
        System.out.println(tagEntity);
        System.out.println("======================================================");

        TagConsoleListVo tagConsoleListVo = tagMapper.toTagConsoleListVo(tagEntity);
        System.out.println(tagConsoleListVo.toString());
        System.out.println("======================================================");

        TagViewListVo tagViewListVo = tagMapper.toTagViewListVo(tagEntity);
        System.out.println(tagViewListVo.toString());
        System.out.println("======================================================");

        List<TagEntity> tagEntities = List.of(tagEntity, tagEntity1);
        System.out.println(tagEntities);
        System.out.println("======================================================");

        List<TagConsoleListVo> tagConsoleListVos = tagMapper.toTagConsoleListVos(tagEntities);
        System.out.println(tagConsoleListVos.toString());
        System.out.println("======================================================");

        List<TagViewListVo> tagViewListVos = tagMapper.toTagViewListVos(tagEntities);
        System.out.println(tagViewListVos.toString());
    }
}
