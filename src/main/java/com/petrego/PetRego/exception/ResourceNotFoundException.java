package com.petrego.PetRego.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Scope: An exception Handler
 *
 * @version 1.0
 * @author Unknown
 * @date 10th September 2019
 * @note This was a snippet found off the internet - I have lost the direct link to it
 *
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        private String resourceName;
        private String fieldName;
        private Object fieldValue;

        public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
            super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
            this.resourceName = resourceName;
            this.fieldName = fieldName;
            this.fieldValue = fieldValue;
        }

        public String getResourceName() {
            return resourceName;
        }

        public String getFieldName() {
            return fieldName;
        }

        public Object getFieldValue() {
            return fieldValue;
        }
}
