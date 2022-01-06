/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.fitness.dao;

/**
 *
 * @author raymondtam
 */
public class GuessValidationException extends Exception {

    public GuessValidationException(String message) {
        super(message);
    }

    public GuessValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
