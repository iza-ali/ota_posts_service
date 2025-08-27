package com.iaali.ota_posts_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO {

    private Long id;

    @NotBlank(message = "Category name is required")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    private String name;

    private boolean deleted;
}
