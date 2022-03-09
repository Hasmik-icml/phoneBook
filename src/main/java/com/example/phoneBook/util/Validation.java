package com.example.phoneBook.util;

import com.example.phoneBook.model.util.Lable;

public final class  Validation {
    public static final int NAME_LENGTH = 10;

    public static final String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static final String regexPhone = "(([+374]{4}|[0]{1}))?([1-9]{2})(\\d{6})";

    public static final Lable[] label = Lable.values(); // [WORK, HOME, PERSONAL]
}