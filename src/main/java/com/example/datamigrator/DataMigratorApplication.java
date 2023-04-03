package com.example.datamigrator;

import com.example.datamigrator.service.EmployeeService;
import com.opencsv.exceptions.CsvException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class DataMigratorApplication {

    public static void main(String[] args) throws IOException, CsvException {
        ConfigurableApplicationContext context = SpringApplication.run(DataMigratorApplication.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        employeeService.saveEmployees("/Users/qendresazeneli/IdeaProjects/data-migrator/src/main/resources/employee.csv");
    }

}
