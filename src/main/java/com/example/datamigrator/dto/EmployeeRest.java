package com.example.datamigrator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRest {

    @JsonProperty("employee_name")
    private String employeeName;
    @JsonProperty("employee_salary")
    private Double employeeSalary;

}
