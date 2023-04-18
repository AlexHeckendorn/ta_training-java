package org.epam.training.Alexander_Heckendorn.validations_epam_email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {
    public static boolean validateEpamEmail(String email) {
        if (email == null) {
            return false;
        }
        // Regular expression to match EPAM email format
        String pattern = "^[a-zA-Z]+_[a-zA-Z]+[0-9]*@epam\\.com$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}





