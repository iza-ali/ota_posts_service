package com.iaali.ota_posts_service.controller;

import com.iaali.ota_posts_service.dto.CategoryDTO;
import com.iaali.ota_posts_service.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable @NotNull @Positive Long id) {

        // Bad request is sent through validation when the ID is out of bounds
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/name")
    public ResponseEntity<CategoryDTO> getCategoryByName(@RequestParam @NotBlank @Size(min = 1, max = 50) String name) {

        // Bad request is sent through validation when the name is out of bounds
        return ResponseEntity.ok(service.getByName(name));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {

        return ResponseEntity.ok(service.getAll());
    }

    @Transactional
    @PostMapping
    public ResponseEntity<CategoryDTO> createNewCategory(@Valid @RequestBody CategoryDTO category) {

        //Bad Request sent through validation when name is out of bounds
        CategoryDTO response = service.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Transactional
    @PatchMapping("/{id}/name")
    public ResponseEntity<CategoryDTO> editCategoryNameById(@Valid @RequestBody CategoryDTO category,
                                                                  @PathVariable @NotNull @Positive Long id) {

        // Bad request is sent through validation when name is out of bounds

        CategoryDTO updatedProfile = service.updateName(id, category.getName());
        return ResponseEntity.ok(updatedProfile);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> softDeleteCategoryById(@PathVariable @NotNull @Positive Long id) {

        // Bad request is sent through validation when the ID is out of bounds
        service.softDeleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    @DeleteMapping("/name")
    public ResponseEntity<Void> softDeleteCategoryByName(@RequestParam @NotBlank @Size(min = 1, max = 50) String name) {

        // Bad request is sent through validation when the ID is out of bounds
        service.softDeleteByName(name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    @DeleteMapping("/{id}/hard")
    public ResponseEntity<Void> hardDeleteCategoryById(@PathVariable @NotNull @Positive Long id) {

        // Bad request is sent through validation when the ID is out of bounds
        service.hardDeleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    @DeleteMapping("/name/hard")
    public ResponseEntity<Void> hardDeleteCategoryByName(@RequestParam @NotBlank @Size(min = 1, max = 50) String name) {

        // Bad request is sent through validation when the ID is out of bounds
        service.hardDeleteByName(name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
