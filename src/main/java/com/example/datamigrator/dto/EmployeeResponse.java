package com.example.datamigrator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

    public String status;
    public ArrayList<EmployeeRest> data;
    public String message;

}


