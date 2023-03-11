package com.aprajapati.dynamicquiz.reader;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class QuestionsSheetReaderTest {

    @Test
    public void testSimple(){
        QuestionsSheetReader reader = new QuestionsSheetReader();
        JSONParser parser = new JSONParser();
        String expected = "[\n" +
                "      {\n" +
                "      \"question\":\"What is the Capital of UK?\",\n" +
                "      \"answers\":[{\n" +
                "        \"optionKey\":\"A\",\n" +
                "        \"optionVal\":\"London\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"optionKey\":\"B\",\n" +
                "        \"optionVal\":\"Yorkshire\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"optionKey\":\"C\",\n" +
                "        \"optionVal\":\"Hampton\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"optionKey\":\"D\",\n" +
                "        \"optionVal\":\"Livingston\"\n" +
                "      }],\n" +
                "      \"correctOptionKey\":\"A\",\n" +
                "      \"correctAnsExplain\":\"London is the Capital of UK since 1654\",\n" +
                "      \"marks\":5\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\":\"What is the Capital of India?\",\n" +
                "      \"answers\":[{\n" +
                "        \"optionKey\":\"A\",\n" +
                "        \"optionVal\":\"Kanpur\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"optionKey\":\"B\",\n" +
                "        \"optionVal\":\"Kolkata\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"optionKey\":\"C\",\n" +
                "        \"optionVal\":\"New Delhi\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"optionKey\":\"D\",\n" +
                "        \"optionVal\":\"Mumbai\"\n" +
                "      }],\n" +
                "      \"correctOptionKey\":\"C\",\n" +
                "      \"correctAnsExplain\":\"Kolkata was the Capital of British India, New Delhi is the current capital of India\",\n" +
                "      \"marks\":5\n" +
                "    }\n" +
                "  \n" +
                "  ]";

        String result = reader.getQuestionsSheetAsJson("C:\\Soft\\Git\\dynamicquiz\\src\\test\\resources\\sheets\\CityCapitals.json");

        assertNotNull(result);
        try{
            assertEquals(parser.parse(expected),parser.parse(result));
        }catch (Exception e){
            log.error(e.getLocalizedMessage());
        }

    }

}
