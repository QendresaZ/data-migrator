package com.example.datamigrator.service;

import com.example.datamigrator.model.Employee;
import com.example.datamigrator.repository.EmployeeRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployees(String fileName) throws IOException, CsvException {
        Reader reader = new FileReader(fileName);
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        List<String[]> rows = csvReader.readAll();
        for (String[] row : rows) {
            Employee employee = new Employee();
            employee.setFirstName(row[0]);
            employee.setLastName(row[1]);
            employee.setEmail(row[2]);
            employee.setPhone(row[3]);
            employeeRepository.save(employee);
        }

    }
}
