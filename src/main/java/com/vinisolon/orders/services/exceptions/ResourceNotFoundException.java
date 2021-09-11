package com.vinisolon.orders.services.exceptions;

// RuntimeException o compilador não te obriga a tratar
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found. ID: " + id);
    }

}
