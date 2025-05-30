package com.devj2k.avaj.launcher.utils;

import com.devj2k.avaj.launcher.exception.BeanValidationException;

public class BeanValidation {

    public static BeanValidation validator() {
        return new BeanValidation();
    }

    public BeanValidation validate(boolean isValid, String errorMessage) {
        if (isValid) {
            return this;
        }
        throw new BeanValidationException(errorMessage);
    }
}
