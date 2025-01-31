package com.example.numbersapi.controllers;

import com.example.numbersapi.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class NumbersApiController {


    @GetMapping("/number}")
    public ResponseEntity<ApiResponse<?>> deriveNumberFunFact()  {
        return (ResponseEntity<ApiResponse<?>>) ResponseEntity.ok();
    }


}