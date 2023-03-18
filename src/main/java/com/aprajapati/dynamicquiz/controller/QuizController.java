package com.aprajapati.dynamicquiz.controller;

import com.aprajapati.dynamicquiz.model.LoginDetails;
import com.aprajapati.dynamicquiz.model.RequestBodyLoginCheck;
import com.aprajapati.dynamicquiz.reader.CatalogueFileReader;
import com.aprajapati.dynamicquiz.reader.LoginFileReader;
import com.aprajapati.dynamicquiz.reader.QuestionsSheetReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
@Slf4j
public class QuizController {

    @Value("${reader.catalogue.index.filelocation}")
    private String indexFileLocation;

    @Value("${reader.login.login.filelocation}")
    private String loginFileLocation;

    @Autowired
    CatalogueFileReader indexFileReader;

    @Autowired
    QuestionsSheetReader sheetReader;

    @Autowired
    LoginFileReader loginFileReader;

    @GetMapping("/getFileData/{fileName}")
    public String getFileData(@PathVariable("fileName") String fileName ){
        return sheetReader.getQuestionsSheetAsJson(fileName);
    }

    @GetMapping("/getIndex")
    public String getFileData(){
        return indexFileReader.readCatalogueFile(indexFileLocation);
    }

    @PostMapping(path="/checkLogin",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginDetails getAvailableLogins(@RequestBody RequestBodyLoginCheck request){
        List<LoginDetails> result = loginFileReader.readLoginFile(loginFileLocation);

        Optional<LoginDetails> oLoginDetails = result.stream().filter(l -> l.getUserid().equals(request.getUserid())
                && l.getPassword().equals(request.getPassword())).findAny();

        if(oLoginDetails.isPresent()){
            return oLoginDetails.get();
        }
        return null;
    }
}
