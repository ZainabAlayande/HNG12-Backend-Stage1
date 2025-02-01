package com.example.numbersapi.services;

import com.example.numbersapi.dto.responses.NumberApiResponse;

public interface NumbersService {

    NumberApiResponse deriveNumberFunFact(String number);

}
