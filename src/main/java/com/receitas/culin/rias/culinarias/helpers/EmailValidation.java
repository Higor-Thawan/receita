package com.receitas.culin.rias.culinarias.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

    public static boolean validation(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches())
            return true;
        return false;
    }
}
