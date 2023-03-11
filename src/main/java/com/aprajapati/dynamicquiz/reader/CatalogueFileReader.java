package com.aprajapati.dynamicquiz.reader;

import com.aprajapati.dynamicquiz.model.AvailableSheets;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class CatalogueFileReader {

    @Value("${dynamic.quiz.mode}")
    protected String mode;

    public String readCatalogueFile(String catalogueFileLocation){
        File catalogueFile = new File(catalogueFileLocation);
        String result;
        if(catalogueFile.exists()){
            CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            try{
                MappingIterator<AvailableSheets> availableSheets = csvMapper.readerFor(AvailableSheets.class)
                        .with(orderLineSchema)
                        .readValues(new File(catalogueFileLocation));
                List<AvailableSheets> toUse = availableSheets.readAll();
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                result = ow.writeValueAsString(toUse);
            }catch (IOException e){
                result = e.getLocalizedMessage();
            }
        }else{
            result = "Catalogue File not found!";
        }

        return result;
    }

}
