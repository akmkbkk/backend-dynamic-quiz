package com.aprajapati.dynamicquiz.controller;

import com.aprajapati.dynamicquiz.reader.CatalogueFileReader;
import com.aprajapati.dynamicquiz.reader.QuestionsSheetReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    CatalogueFileReader indexFileReader;

    @Autowired
    QuestionsSheetReader sheetReader;

    @GetMapping("/getFileData/{fileName}")
    public String getFileData(@PathVariable("fileName") String fileName ){
        return sheetReader.getQuestionsSheetAsJson(fileName);
    }

    @GetMapping("/getIndex")
    public String getFileData(){
        return indexFileReader.readCatalogueFile("C:\\Soft\\Git\\dynamicquiz-files\\catalogue\\DST_Sheets_index.csv");
    }
}
