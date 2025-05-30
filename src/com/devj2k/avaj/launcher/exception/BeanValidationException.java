/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */

package com.devj2k.avaj.launcher.exception;

/**
 *
 * @author theo
 */
public class BeanValidationException extends RuntimeException {

    /**
     * Creates a new instance of <code>BeanValidationException</code> without detail message.
     */
    public BeanValidationException() {
    }


    /**
     * Constructs an instance of <code>BeanValidationException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public BeanValidationException(String msg) {
        super(msg);
    }
}
