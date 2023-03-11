package com.aprajapati.dynamicquiz.reader;

import com.aprajapati.dynamicquiz.model.AvailableSheets;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@Slf4j
public class CatalogueFileReader {

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
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                result = ow.writeValueAsString(availableSheets.readAll());
            }catch (IOException e){
                result = e.getLocalizedMessage();
            }
        }else{
            result = "Catalogue File not found!";
        }

        return result;
    }

}
