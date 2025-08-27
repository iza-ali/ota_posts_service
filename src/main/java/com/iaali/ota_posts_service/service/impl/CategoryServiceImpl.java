package com.iaali.ota_posts_service.service.impl;

import com.iaali.ota_posts_service.dto.CategoryDTO;
import com.iaali.ota_posts_service.entity.CategoryEntity;
import com.iaali.ota_posts_service.exception.ErrorEnum;
import com.iaali.ota_posts_service.exception.GlobalException;
import com.iaali.ota_posts_service.mapper.CategoryMapper;
import com.iaali.ota_posts_service.repository.CategoryRepository;
import com.iaali.ota_posts_service.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository repository;
    private CategoryMapper mapper;

    @Override
    public CategoryDTO getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new GlobalException(id, ErrorEnum.NOT_FOUND_ID));
    }

    @Override
    public CategoryDTO getByName(String name) {
        return repository.findByName(name)
                .map(mapper::toDTO)
                .orElseThrow(() -> new GlobalException(name, ErrorEnum.NOT_FOUND_CATEGORY_NAME));
    }

    @Override
    public List<CategoryDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        String name = dto.getName();

        if (repository.existsByName(name)){
            throw new GlobalException(name, ErrorEnum.CONFLICT_CATEGORY_NAME_ALREADY_EXISTS);
        }

        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public CategoryDTO updateName(Long id, String name) {
        CategoryEntity entity = repository.findById(id)
                .orElseThrow(() -> new GlobalException(id, ErrorEnum.NOT_FOUND_ID));

        entity.setName(name);
        CategoryEntity response = repository.save(entity);
        return mapper.toDTO(response);
    }

    @Override
    public void softDeleteById(Long id) {
        CategoryEntity entity = repository.findById(id)
                .orElseThrow(() -> new GlobalException(id, ErrorEnum.NOT_FOUND_ID));

        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public void softDeleteByName(String name) {
        CategoryEntity entity = repository.findByName(name)
                .orElseThrow(() -> new GlobalException(name, ErrorEnum.NOT_FOUND_CATEGORY_NAME));

        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public void hardDeleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new GlobalException(id, ErrorEnum.NOT_FOUND_ID);
        }

        repository.deleteById(id);
    }

    @Override
    public void hardDeleteByName(String name) {
        if (!repository.existsByName(name)) {
            throw new GlobalException(name, ErrorEnum.NOT_FOUND_CATEGORY_NAME);
        }

        repository.deleteByName(name);
    }
}
