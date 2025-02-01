package com.example.numbersapi.dto.responses;

public class ErrorResponse{

    private String number;
    private boolean error;
    private String message;

    public ErrorResponse(String number, boolean error, String message) {
        this.number = number;
        this.error = error;
        this.message = message;
    }

    public String getNumber() {
        return number;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

}
