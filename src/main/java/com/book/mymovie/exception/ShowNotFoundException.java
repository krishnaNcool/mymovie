package com.book.mymovie.exception;

public class ShowNotFoundException extends RuntimeException{

    public ShowNotFoundException(String message) {
        super(message);
    }
}
