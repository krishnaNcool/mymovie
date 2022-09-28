package com.book.mymovie.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static com.book.mymovie.model.UserPermission.*;


@Getter
@AllArgsConstructor
public enum UserRole {
    ROLE_USER(Arrays.asList(READ)),
    ROLE_MANAGER(Arrays.asList(READ, WRITE)),
    ROLE_THEATRE_MANAGER(Arrays.asList(READ,WRITE,UPDATE,DELETE)),
    ROLE_ADMIN(Arrays.asList(READ, WRITE, UPDATE)),
    ROLE_SUPER_ADMIN(Arrays.asList(READ, WRITE, UPDATE, DELETE, APPROVE, REJECT));
    private final List<UserPermission> permissions;
}
