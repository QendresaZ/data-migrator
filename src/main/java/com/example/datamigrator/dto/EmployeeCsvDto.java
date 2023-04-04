package com.example.datamigrator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCsvDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
