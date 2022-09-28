package com.book.mymovie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserPermission {
    READ,
    WRITE,
    UPDATE,
    DELETE,
    APPROVE,
    REJECT
}