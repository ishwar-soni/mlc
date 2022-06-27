package com.example.domain.exception;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException{

    private final ErrorCode code;
    private final Object[] params;

    public DomainException(String message, ErrorCode code, Object... params) {
        super(message);
        this.code = code;
        this.params = params;
    }

    public enum ErrorCode {
        CACHE_PROVIDER_NOT_FOUND,
        STORAGE_FULL,
    }
}
