package com.minato.art.apex.gain.common.constant;

import lombok.Getter;

public enum ErrorMessage {

    REPOSITORY_NULL("JpaRepository must not be null"),
    MAPPER_NULL("DomainMapper must not be null");
    @Getter
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

}
