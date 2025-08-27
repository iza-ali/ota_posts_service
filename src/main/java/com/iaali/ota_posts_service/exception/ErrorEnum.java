package com.iaali.ota_posts_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorEnum {

    //  For all entities
    NOT_FOUND_ID(HttpStatus.NOT_FOUND, "Could not find resource with ID "),

    //  For categories
    NOT_FOUND_CATEGORY_NAME(HttpStatus.NOT_FOUND, "Could not find category with name "),
    CONFLICT_CATEGORY_NAME_ALREADY_EXISTS(HttpStatus.CONFLICT, "This category already exists: ");

    private final HttpStatus status;
    private final String description;

}
