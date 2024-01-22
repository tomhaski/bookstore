package com.bookstore.tools;

import lombok.Getter;

public enum ResponseValues {

    BOOK_CREATED("Book has been created successfully."),
    BOOK_EXIST("Book already exists."),
    BOOK_DELETED("Book has been deleted successfully.");

    @Getter
    private final String message;

    ResponseValues(final String message) {
        this.message = message;
    }
}
