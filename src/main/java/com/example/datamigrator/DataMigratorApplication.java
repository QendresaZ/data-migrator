package com.example.datamigrator;

import com.example.datamigrator.rest.EmployeeClient;
import com.example.datamigrator.service.EmployeeService;
import com.opencsv.exceptions.CsvException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DataMigratorApplication implements CommandLineRunner {

    private final EmployeeService employeeService;

    public DataMigratorApplication(EmployeeService employeeService, EmployeeClient employeeClient) {
        this.employeeService = employeeService;
    }

    public static void main(String[] args) throws CsvException {
        SpringApplication.run(DataMigratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //employeeService.saveEmployeesCsv("");
       // employeeService.saveEmployeesRest("");
    }

}
