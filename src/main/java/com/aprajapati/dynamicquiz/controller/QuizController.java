package com.aprajapati.dynamicquiz.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @GetMapping("/getFileData/{fileName}")
    public String getFileData(@PathVariable("fileName") String fileName ){
        String res = "[\n" +
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

        return res;
    }
}
