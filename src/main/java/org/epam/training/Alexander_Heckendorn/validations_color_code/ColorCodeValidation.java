package org.epam.training.Alexander_Heckendorn.validations_color_code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String colorCode) {
        if (colorCode == null) {
            return false;
        }
        // Regular expression to match valid HTML color codes
        String pattern = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(colorCode);
        return m.matches();
    }
}





