package com.aprajapati.dynamicquiz.reader;

import com.aprajapati.dynamicquiz.model.LoginDetails;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class LoginFileReaderTest {

    @Test
    public void testNotNull(){
        LoginFileReader loginFileReader = new LoginFileReader();

        List<LoginDetails> result = loginFileReader.readLoginFile("C:\\Soft\\Git\\dynamicquiz\\src\\test\\resources\\login\\logins.csv");
        assertNotNull(result);
        assertEquals(2,result.size());
    }



}
