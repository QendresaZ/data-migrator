package com.example.datamigrator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveEmployeesRequest {
    private String csvFilePath;
    private String employeesEndpoint;
}
