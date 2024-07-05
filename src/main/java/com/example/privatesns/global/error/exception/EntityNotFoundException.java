package com.example.privatesns.global.error.exception;

import com.example.privatesns.global.error.ErrorCode;
import com.example.privatesns.global.error.exception.BusinessException;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(String message) {
        super(message, ErrorCode.ENTITY_NOT_FOUND);
    }
}
