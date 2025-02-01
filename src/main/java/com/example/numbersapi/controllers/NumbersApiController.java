package com.example.numbersapi.controllers;

import com.example.numbersapi.dto.responses.ApiResponse;
import com.example.numbersapi.dto.responses.NumberApiResponse;
import com.example.numbersapi.services.NumbersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        NumberApiResponse response = numbersService.deriveNumberFunFact(number);
        return ResponseEntity.ok(response);
    }


}