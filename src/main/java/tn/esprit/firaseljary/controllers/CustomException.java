package tn.esprit.firaseljary.controllers;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}