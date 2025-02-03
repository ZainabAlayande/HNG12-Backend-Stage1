package com.example.numbersapi.controllers;

import com.example.numbersapi.dto.responses.ErrorResponse;
import com.example.numbersapi.dto.responses.NumberApiResponse;
import com.example.numbersapi.services.NumbersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumbersApiController {

    private final NumbersService numbersService;

    public NumbersApiController(NumbersService numbersService) {
        this.numbersService = numbersService;
    }


    @GetMapping("api/classify-number")
    public ResponseEntity<?> deriveNumberFunFact(@RequestParam("number") String number) {
        String validationError = validateNumber(number);

        if (validationError != null) {
            return new ResponseEntity<>(buildErrorResponse(number, validationError), HttpStatus.BAD_REQUEST);
        }

        NumberApiResponse response = numbersService.deriveNumberFunFact(number);
        return ResponseEntity.ok(response);
    }

    private String validateNumber(String number) {
        if (number == null || number.isEmpty()) {
            return "Number cannot be empty";
        }
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return "Invalid number format";
        }
//        if (Integer.parseInt(number) < 0) {
//            return "Number cannot be negative";
//        }

        return null;
    }


    private Object buildErrorResponse(String number, String errorMessage) {
        return new ErrorResponse(number, true, errorMessage);
    }




}