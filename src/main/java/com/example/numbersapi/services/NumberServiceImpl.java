package com.example.numbersapi.services;

import com.example.numbersapi.dto.responses.FunFactResponse;
import com.example.numbersapi.dto.responses.NumberApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class NumberServiceImpl implements NumbersService {

    @Override
    public NumberApiResponse deriveNumberFunFact(String number) {
        boolean isPrime = determineIfPrimeNumber(Integer.parseInt(number));
        boolean isPerfect = determineIfPerfectNumber(Integer.parseInt(number));
        int totalSum = deriveSum(Integer.parseInt(number));
        List<String> numberProperties = getNumberProperties(Integer.parseInt(number));
        String funFact = getNumberFunFact(Integer.parseInt(number));
        return buildNumberApiResponse(number, isPrime, isPerfect, totalSum, numberProperties, funFact);
    }

    private NumberApiResponse buildNumberApiResponse(String number, boolean isPrime, boolean isPerfect, int totalSum,
                                                     List<String> numberProperties, String funFact) {
        NumberApiResponse apiResponse = new NumberApiResponse();
        apiResponse.setNumber(number);
        apiResponse.setClass_sum(totalSum);
        apiResponse.setFun_fact(funFact);
        apiResponse.setProperties(numberProperties);
        apiResponse.setIs_perfect(isPerfect);
        apiResponse.setIs_prime(isPrime);
        return apiResponse;
    }



    private String getNumberFunFact(int number) {
        String url = "http://numbersapi.com/" + number + "/math?json=true";
        RestTemplate restTemplate = new RestTemplate();
        FunFactResponse response = restTemplate.getForObject(url, FunFactResponse.class);
        if (response != null && response.isFound()) {
            return response.getText();
        } else {
            return "No fun fact found for this number";
        }
    }


    public static boolean isArmstrong(int num) {
        int sum = 0, temp = num;
        int digits = String.valueOf(num).length();

        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }
        return sum == num;
    }


    private List<String> getNumberProperties(int i) {
        List<String> numberProperties = new ArrayList<>();
        if (isArmstrong(i)) numberProperties.add("Armstrong");
        if (i % 2 == 0) numberProperties.add("Even");
        else numberProperties.add("Odd");
        return numberProperties;
    }


    private int deriveSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }


    private boolean determineIfPerfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }


    private boolean determineIfPrimeNumber(int i) {
        if (i < 2) return false;
        if (i == 2 || i == 3) return true;
        if (i % 2 == 0 || i % 3 == 0) return false;

        for (int j = 5; j * j <= i; j += 6) {
            if (i % j == 0 || i % (j + 2) == 0) return false;
        }
        return true;
    }

}
