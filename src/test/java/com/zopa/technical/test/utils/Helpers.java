package com.zopa.technical.test.utils;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import com.github.rkumsher.date.RandomDateUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class Helpers {

    public String randomValuesFromList(List<String> using) {
        Random r = new Random();
        if (!using.isEmpty()) {
            return using.get(r.nextInt(using.size() - 1));
        }
        else {
            throw new RuntimeException("List is empty that can be due to any reason .......please run test again");
        }
    }


    public int randomNumberInRange(int max, int min) {
        Random rand = new Random();
        return max + rand.nextInt((max - min) + 1);
    }

    public String generateString() {
       return RandomStringUtils.randomAlphanumeric(20);

    }

    public void storeTestDataToFile(String json) {
        try {
            FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "/target/test-data.json", true);
            fileWriter.write(json);
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String dobOver20(){
        LocalDate today = LocalDate.now();
        return RandomDateUtils.randomLocalDateBefore(today.minus(20, ChronoUnit.YEARS)).toString();
    }
}
