package com.example.datamigrator.web;

import com.example.datamigrator.dto.SaveEmployeesRequest;
import com.example.datamigrator.service.EmployeeService;
import com.opencsv.exceptions.CsvException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Void> saveEmployee(@RequestBody SaveEmployeesRequest saveEmployeesRequest) throws IOException {
        employeeService.saveEmployeesRest(saveEmployeesRequest.getEmployeesEndpoint());
        employeeService.saveEmployeesCsv(saveEmployeesRequest.getCsvFilePath());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
