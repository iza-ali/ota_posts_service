package com.iaali.ota_posts_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorEnum {

    //  For all entities
    NOT_FOUND_ID(HttpStatus.NOT_FOUND, "Could not find resource with ID ");

    private final HttpStatus status;
    private final String description;

}
