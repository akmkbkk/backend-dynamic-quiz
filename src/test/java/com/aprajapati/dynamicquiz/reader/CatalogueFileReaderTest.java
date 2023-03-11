package com.aprajapati.dynamicquiz.reader;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class CatalogueFileReaderTest {

    @Test
    public void testSimple() throws ParseException {
        CatalogueFileReader mainFileReader = new CatalogueFileReader();
        mainFileReader.mode = "demo";
        String result = mainFileReader.readCatalogueFile("C:\\Soft\\Git\\dynamicquiz\\src\\test\\resources\\catalogue\\DST_Sheets_index.csv");

        String expected = "[{\n" +
                "\t\"testName\": \"Countries And their Capitals\",\n" +
                "\t\"fileName\": \"Countries_And_their_Capitals\",\n" +
                "\t\"totalMarks\": \"50\",\n" +
                "\t\"testDesc\": \"Countries and their capital questions\"\n" +
                "}, {\n" +
                "\t\"testName\": \"States and their Capitals\",\n" +
                "\t\"fileName\": \"States_and_their_Capitals\",\n" +
                "\t\"totalMarks\": \"50\",\n" +
                "\t\"testDesc\": \"States and their Capitals questions\"\n" +
                "}]";
        JSONParser parser = new JSONParser();
        JSONArray arrExpected = (JSONArray) parser.parse(expected);
                assertNotNull(result);
        assertEquals(arrExpected,parser.parse(result));


    }
}
