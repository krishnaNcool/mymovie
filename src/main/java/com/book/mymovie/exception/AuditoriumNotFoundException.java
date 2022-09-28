package com.book.mymovie.exception;

public class AuditoriumNotFoundException extends RuntimeException {

    public AuditoriumNotFoundException(String message) {
        super(message);
    }
}
