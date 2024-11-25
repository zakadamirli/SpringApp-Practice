package com.zekademirli.lareshomeworks.exception;

import com.zekademirli.lareshomeworks.response.CustomerResponse;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String customerNotFound) {
        super();
    }
}
