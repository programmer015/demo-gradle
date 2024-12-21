package com.thinkinnovative.demo_gradle.exception;

public class CloudVendorNotFoundException extends RuntimeException
{

    public CloudVendorNotFoundException(String message) {
        super(message);
    }

    public CloudVendorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
