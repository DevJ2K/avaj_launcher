package com.devj2k.avaj.launcher;

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

    public static void main(String[] args) {
        validator()
        .validate(true, "")
        .validate(false, "False");
    }
}
