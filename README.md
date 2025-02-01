# Numbers API Service

## Overview

The **Numbers API Service** is a Spring Boot application that allows you to retrieve mathematical properties and fun facts about numbers. This service provides information such as whether a number is prime, perfect, Armstrong, or odd/even, along with a fun fact from the Numbers API.

## Features

- **Prime Check**: Determines if a number is a prime number.
- **Perfect Number Check**: Determines if a number is a perfect number.
- **Armstrong Check**: Determines if a number is an Armstrong number.
- **Fun Fact**: Fetches a fun fact about a number from the Numbers API.

## Endpoint

### Example Request
#### 1. `GET http://localhost:8080/api/classify-number?number=371`

This endpoint returns detailed information about a number, including properties like prime, perfect, Armstrong, and a fun fact.


### Example Response
```
{
    "number": "371",
    "is_prime": false,
    "is_perfect": false,
    "properties": ["Armstrong", "Odd"],
    "class_sum": 11,
    "fun_fact": "371 is an Armstrong number because 3^3 + 7^3 + 1^3 = 371"
}
```


## Technologies Used
- Spring Boot: The main framework used to build the API.
- Java: The programming language used for backend logic.
- Numbers API: Used to fetch fun facts about numbers.
- RestTemplate: Used for making API calls to the Numbers API.


## Setup Instructions

### Prerequisites
- Java 8 or above
- Maven
- Spring Boot


## Steps to Run Locally
1. Clone the Repository:

`
git clone https://github.com/ZainabAlayande/HNG12-Backend-Stage1.git
`
2. Navigate to the Project Directory:

`cd numbers-api`

3. Build the Application:

`mvn clean install`

4. Run the Application:

`mvn spring-boot:run`

5. Access the API:

- Open a browser or API tool (e.g., Postman) and make `GET` requests to
  `http://localhost:8080/number?number=<your-number>.`


