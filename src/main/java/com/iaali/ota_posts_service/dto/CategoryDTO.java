package com.iaali.ota_posts_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO {

    private Long followedId;

    @NotNull(message = "Category name is required")
    private String name;
}
