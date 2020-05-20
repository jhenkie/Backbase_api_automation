package com.factory.cucumber.pages;

import com.aventstack.extentreports.Status;
import com.cucumber.listener.Reporter;
import org.junit.Assert;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Function {
    public static void writeToFile(String email) {
        try {
            FileWriter writer = new FileWriter("src/test/reports/emailGenerator.txt");
            writer.write(email);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile() {
        String getEmail="";
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/reports/emailGenerator.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getEmail;
    }

    public static String increaseEmailNumber() {
        String oldEmail,newEmail = "";
        int number,addNumber = 0;

        oldEmail = readFromFile();
        number = Integer.parseInt(oldEmail.substring(oldEmail.indexOf("@")-1,oldEmail.indexOf("@")));
        addNumber =number+1;
        newEmail = oldEmail.replace(String.valueOf(number),String.valueOf(addNumber));
        writeToFile(newEmail);
        return newEmail;
    }

    public void assertValue(String check,String actual, String expected) {
        if(check.equals("code") && expected.equals(actual)) {
            Assert.assertEquals(expected, actual);
            Reporter.addStepLog(Status.PASS+" Actual response code :"+actual);
            Reporter.addStepLog(Status.PASS+" Expected response code :"+expected);
        } else if(check.equals("value") && expected.equals(actual)) {
            Assert.assertEquals(expected, actual);
            Reporter.addStepLog(Status.PASS+" Actual value :"+actual);
            Reporter.addStepLog(Status.PASS+" Expected value :"+expected);
        } else {
            Assert.assertEquals(expected, actual);
        }
    }
}

