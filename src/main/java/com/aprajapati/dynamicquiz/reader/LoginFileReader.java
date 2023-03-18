package com.aprajapati.dynamicquiz.reader;

import com.aprajapati.dynamicquiz.model.LoginDetails;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class LoginFileReader {


    public List<LoginDetails> readLoginFile(String loginFileLocation){
        File loginFile = new File(loginFileLocation);
        List<LoginDetails> result = new ArrayList<>();
        if(loginFile.exists()){
            CsvSchema loginDetails = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            try{
                MappingIterator<LoginDetails> availableLogins = csvMapper.readerFor(LoginDetails.class)
                        .with(loginDetails)
                        .readValues(new File(loginFileLocation));
                result = availableLogins.readAll();
            }catch (IOException e){
                log.error("Can not get logins - returning empty array - {}",e.getMessage());
            }
        }

        return result;
    }
}
