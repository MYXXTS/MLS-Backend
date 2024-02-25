package com.myxxts.mls.util.mapper;

import com.myxxts.mls.module.core.category.CategoryEntity;
import com.myxxts.mls.module.core.category.vo.CategoryConsoleListVo;
import com.myxxts.mls.module.core.category.vo.CategoryViewListVo;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CategoryMapperTests {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertThat(context).isNotNull();
    }

    @Test
    void testCategoryEntityToVoMapper() {
        ObjectId userId = new ObjectId();
        CategoryEntity categoryEntity = new CategoryEntity(
                userId,
                userId,
                "test category",
                "test category description"
        );
        CategoryEntity childCategoryEntity = new CategoryEntity(
                userId,
                userId,
                "test child category",
                "test child category description"
        );
        CategoryEntity categoryEntity1 = new CategoryEntity(
                userId,
                userId,
                childCategoryEntity,
                "test category 1",
                "test category description 1"
        );
        System.out.println(categoryEntity);
        System.out.println("======================================================");

        System.out.println(childCategoryEntity);
        System.out.println("======================================================");

        System.out.println(categoryEntity1);
        System.out.println("======================================================");

        CategoryConsoleListVo categoryConsoleListVo = categoryMapper.toCategoryConsoleListVo(categoryEntity1);
        System.out.println(categoryConsoleListVo.toString());
        System.out.println("======================================================");

        CategoryViewListVo categoryViewListVo = categoryMapper.toCategoryViewListVo(categoryEntity1);
        System.out.println(categoryViewListVo.toString());
        System.out.println("======================================================");

        List<CategoryEntity> categoryEntities = List.of(categoryEntity, categoryEntity1);
        System.out.println(categoryEntities);
        System.out.println("======================================================");

        List<CategoryConsoleListVo> categoryConsoleListVos = categoryMapper.toCategoryConsoleListVo(categoryEntities);
        System.out.println(categoryConsoleListVos.toString());
        System.out.println("======================================================");

        List<CategoryViewListVo> categoryViewListVos = categoryMapper.toCategoryViewListVo(categoryEntities);
        System.out.println(categoryViewListVos.toString());
    }
}
