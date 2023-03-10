package com.aprajapati.dynamicquiz.reader;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;

@Component
@Slf4j
public class QuestionsSheetReader {

    @Value("${reader.questions.formatextension}")
    protected String sheetFormatExtension;

    @Value("${reader.questions.rootdir}")
    protected String sheetsRootDir;

    public String getQuestionsSheetAsJson(String sheetName){
        sheetName = sheetsRootDir+File.separator+sheetName+sheetFormatExtension;
        File sheetFile = new File(sheetName);
        String result;
        if(sheetFile.exists()){
            JSONParser parser = new JSONParser();

            try{
                Object obj = parser.parse(new FileReader(sheetName));
                JSONArray jsonArray = (JSONArray)obj;
                result =  jsonArray.toJSONString();
            } catch (Exception e){
                log.error("Exception parsing the file contents - {}",e.getMessage());
                result =  e.getMessage();
            }
        }else{
            result = "File does not exists";
        }
        return result;
    }
}
