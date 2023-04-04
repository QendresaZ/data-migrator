package com.example.datamigrator.service;

import com.example.datamigrator.dto.EmployeeCsvDto;
import com.example.datamigrator.dto.EmployeeRest;
import com.example.datamigrator.dto.SaveEmployeesRequest;
import com.example.datamigrator.mapper.EmployeeMapper;
import com.example.datamigrator.repository.EmployeeRepository;
import com.example.datamigrator.rest.EmployeeClient;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeClient employeeClient;

    private final EmployeeMapper employeeMapper;
    private final CsvDataProvider csvDataProvider;


    public EmployeeService(EmployeeRepository employeeRepository, EmployeeClient employeeClient,
                           EmployeeMapper employeeMapper, CsvDataProvider csvDataProvider) {
        this.employeeRepository = employeeRepository;
        this.employeeClient = employeeClient;
        this.employeeMapper = employeeMapper;
        this.csvDataProvider = csvDataProvider;
    }

    public void saveEmployeesCsv(String filePath) throws IOException {
        List<EmployeeCsvDto> data = csvDataProvider.getData(filePath);
        for (EmployeeCsvDto employeeCsvDto: data) {
            employeeRepository.save(employeeMapper.toEmployee(employeeCsvDto));
        }
    }

    public void saveEmployeesRest(String endpoint) {
        ArrayList<EmployeeRest> employeeRests = employeeClient.fetchEmployees(endpoint);
        for (EmployeeRest employeeRest: employeeRests) {
            employeeRepository.save(employeeMapper.toEmployee(employeeRest));
        }
    }
}
