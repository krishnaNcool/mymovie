package com.book.mymovie.exception;

public class MovieShowNotFoundException extends RuntimeException {
    public MovieShowNotFoundException(String message) {
        super(message);
    }
}
