package com.iaali.ota_posts_service.repository;

import com.iaali.ota_posts_service.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    boolean existsByName(String name);

    void deleteByName(String name);

    Optional<CategoryEntity> findByName(String name);
}
