package com.aprajapati.dynamicquiz.reader;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class CatalogueFileReaderTest {

    @Test
    public void testSimple(){
        CatalogueFileReader mainFileReader = new CatalogueFileReader();
        String expected = "[{\n" +
                "    testName:\"Countries And their Capitals\",\n" +
                "    fileName:\"Countries_And_their_Capitals\",\n" +
                "    totalMarks:\"50\",\n" +
                "    testDesc:\"Countries and their capital questions\"\n" +
                "  },{\n" +
                "    testName:\"States and their Capitals\",\n" +
                "    fileName:\"States_and_their_Capitals\",\n" +
                "    totalMarks:\"50\",\n" +
                "    testDesc:\"States and their Capitals questions\"\n" +
                "  }]";
        JSONParser parser = new JSONParser();
        String result = mainFileReader.readCatalogueFile("C:\\Soft\\Git\\dynamicquiz\\src\\test\\resources\\catalogue\\DST_Sheets_index.csv");
        assertNotNull(result);
        try{
            assertEquals(parser.parse(expected),parser.parse(result));
        }catch (Exception e){
            log.error(e.getLocalizedMessage());
        }


    }
}
