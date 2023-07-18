package org.example.core;

import java.util.regex.Pattern;

public class CommandPageMatthods {

    /**
     * Regular Expression to Check Characters in the Top-Level Domain
     */
    public static boolean emailPatternMatches(String email){
        String regexPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
                + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return Pattern.compile(regexPattern)

                .matcher(email)

                .matches();
    }

    public static boolean passwordPatternMatches(String password){
        String passwordPattern = "^(?:(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)|(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)|(?=.*[a-z])(?=.*\\d)(?=.*\\W)|(?=.*[A-Z])(?=.*\\d)(?=.*\\W)).{8,}$";
        return Pattern.compile(passwordPattern)

                .matcher(password)

                .matches();
    }
}
