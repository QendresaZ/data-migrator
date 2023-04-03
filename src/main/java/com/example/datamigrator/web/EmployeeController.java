package com.example.datamigrator.web;

import com.example.datamigrator.service.EmployeeService;
import com.opencsv.exceptions.CsvException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

//@RestController("/api/employee")
//public class EmployeeController {
//
//    private final EmployeeService employeeService;
//
//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//
//    @PostMapping()
//    public ResponseEntity<Void> saveEmployee() throws IOException, CsvException {
//        employeeService.saveEmployees("/Users/qendresazeneli/IdeaProjects/data-migrator/src/main/resources/employee.csv");
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
