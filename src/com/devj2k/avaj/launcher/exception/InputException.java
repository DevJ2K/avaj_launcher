/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */

package com.devj2k.avaj.launcher.exception;

/**
 *
 * @author theo
 */
public class InputException extends Exception {

    /**
     * Creates a new instance of <code>InputException</code> without detail message.
     */
    public InputException() {
    }


    /**
     * Constructs an instance of <code>InputException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public InputException(String msg) {
        super(msg);
    }
}
