package com.example.datamigrator.service;

import com.example.datamigrator.dto.EmployeeCsvDto;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Service
public class CsvDataProvider {

    public List<EmployeeCsvDto> getData(String fileName) throws IOException {
        Reader reader = new BufferedReader(new FileReader(fileName));
        CsvToBean<EmployeeCsvDto> csvReader = new CsvToBeanBuilder<EmployeeCsvDto>(reader)
                .withType(EmployeeCsvDto.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return csvReader.parse();
    }

}
