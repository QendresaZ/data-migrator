package com.example.datamigrator.rest;

import com.example.datamigrator.dto.EmployeeResponse;
import com.example.datamigrator.dto.EmployeeRest;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class EmployeeClient {

    private final RestTemplate restTemplate;

    public EmployeeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ArrayList<EmployeeRest> fetchEmployees(String endpoint) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<EmployeeResponse> response = restTemplate.exchange(
                endpoint,
                HttpMethod.GET,
                entity,
                EmployeeResponse.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            EmployeeResponse employeeResponse = response.getBody();

            return employeeResponse.getData();
        }
        return null;
    }

}
