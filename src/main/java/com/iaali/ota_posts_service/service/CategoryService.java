package com.iaali.ota_posts_service.service;

import com.iaali.ota_posts_service.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO getById(Long id);

    CategoryDTO getByName(String name);

    List<CategoryDTO> getAll();

    CategoryDTO save(CategoryDTO dto);

    CategoryDTO updateName(Long id, String name);

    void softDeleteById(Long id);

    void softDeleteByName(String name);

    void hardDeleteById(Long id);

    void hardDeleteByName(String name);
}
