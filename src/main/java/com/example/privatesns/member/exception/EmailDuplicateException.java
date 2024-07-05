package com.example.privatesns.member.exception;

import com.example.privatesns.global.error.ErrorCode;
import com.example.privatesns.global.error.exception.InvalidValueException;

public class EmailDuplicateException extends InvalidValueException {

    public EmailDuplicateException(final String email) {
        super(email, ErrorCode.MEMBER_ALREADY_REGISTERED);
    }
}
