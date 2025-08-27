package com.iaali.ota_posts_service.mapper;

import com.iaali.ota_posts_service.dto.CategoryDTO;
import com.iaali.ota_posts_service.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(CategoryEntity categoryEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "name", target = "name")
    @Mapping(target = "deleted", ignore = true)
    CategoryEntity toEntity(CategoryDTO categoryDTO);
}
