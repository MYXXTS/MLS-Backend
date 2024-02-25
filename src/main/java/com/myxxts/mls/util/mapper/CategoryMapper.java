package com.myxxts.mls.util.mapper;

import com.myxxts.mls.module.core.category.CategoryEntity;
import com.myxxts.mls.module.core.category.vo.CategoryConsoleListVo;
import com.myxxts.mls.module.core.category.vo.CategoryViewListVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

    public CategoryConsoleListVo toCategoryConsoleListVo(CategoryEntity categoryEntity){
        if (categoryEntity == null) {
            return null;
        }

        CategoryConsoleListVo categoryConsoleListVo = new CategoryConsoleListVo();

        categoryConsoleListVo.setCreateBy( categoryEntity.getCreateBy() );
        categoryConsoleListVo.setUpdateBy( categoryEntity.getUpdateBy() );
        categoryConsoleListVo.setCreateTime( categoryEntity.getCreateTime() );
        categoryConsoleListVo.setUpdateTime( categoryEntity.getUpdateTime() );
        categoryConsoleListVo.setCid( categoryEntity.getCid().toHexString() );
        categoryConsoleListVo.setArticleCount( categoryEntity.getArticleCount() );
        categoryConsoleListVo.setName( categoryEntity.getName() );
        categoryConsoleListVo.setDescription( categoryEntity.getDescription() );

        CategoryEntity child = categoryEntity.getChild();
        if ( child != null ) {
            categoryConsoleListVo.setChild( toCategoryConsoleListVo( child ) );
        }

        return categoryConsoleListVo;
    }

    public abstract List<CategoryConsoleListVo> toCategoryConsoleListVo(List<CategoryEntity> categoryEntity);

    public CategoryViewListVo toCategoryViewListVo(CategoryEntity categoryEntity){
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryViewListVo categoryViewListVo = new CategoryViewListVo();

        categoryViewListVo.setCreateBy( categoryEntity.getCreateBy() );
        categoryViewListVo.setUpdateBy( categoryEntity.getUpdateBy() );
        categoryViewListVo.setCreateTime( categoryEntity.getCreateTime() );
        categoryViewListVo.setUpdateTime( categoryEntity.getUpdateTime() );
        categoryViewListVo.setCid( categoryEntity.getCid().toHexString() );
        categoryViewListVo.setName( categoryEntity.getName() );
        categoryViewListVo.setDescription( categoryEntity.getDescription() );
        categoryViewListVo.setRoute( categoryEntity.getRoute() );

        CategoryEntity child = categoryEntity.getChild();

        if ( child != null ) {
            categoryViewListVo.setChild( toCategoryViewListVo( child ) );
        }

        return categoryViewListVo;
    }

    public abstract List<CategoryViewListVo> toCategoryViewListVo(List<CategoryEntity> categoryEntity);
}
