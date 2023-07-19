package org.example.core.data;

import org.testng.annotations.DataProvider;

public class DataProviderMethods {
    @DataProvider
    public Object[][] dataForCreateAccountTest(){
        return  new Object[][] {
                {"", "", "", "", "",},
                {"", "test-lastname", "i@idiot.com", "12345678", "123456"},
                {"bla", "vla", "", "dVbSYT_$1090", "dVbSYT_$1090"},
                {"bitle", "dwesd", "ichbin@dumm.com", "dVbSYT_$1090", "dVbSYT_$1090"},
        };
    }
    @DataProvider
    public  Object[][] dataForSearchingClothes(){
        return  new Object[][] {
                {"yoga"},
                {"jacket"},
                {"short"},
                {"watch"}
        };

    }
    @DataProvider
    public  Object[][] dataForSinging(){
        return  new Object[][] {
                {"", ""},
                {"aaa", ""},
                {"", "aaa"},
                {"sas", "aa@aa.com"},

        };
}}
