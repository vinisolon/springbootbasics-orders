package com.vinisolon.orders.services.exceptions;

// RuntimeException o compilador não te obriga a tratar
public class DatabaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DatabaseException(String msg) {
        super(msg);
    }

}
