package com.example.datamigrator.mapper;

import com.example.datamigrator.dto.EmployeeCsvDto;
import com.example.datamigrator.dto.EmployeeRest;
import com.example.datamigrator.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEmployee(EmployeeRest employeeRest) {
        String fullName = employeeRest.getEmployeeName();
        int idx = fullName.lastIndexOf(' ');
        String firstName = fullName.substring(0, idx);
        String lastName = fullName.substring(idx + 1);
        return Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .salary(employeeRest.getEmployeeSalary())
                .build();
    }

    public Employee toEmployee(EmployeeCsvDto employeeCsvDto) {
        return Employee.builder()
                .firstName(employeeCsvDto.getFirstName())
                .lastName(employeeCsvDto.getLastName())
                .email(employeeCsvDto.getEmail())
                .phone(employeeCsvDto.getPhone())
                .build();
    }

}
