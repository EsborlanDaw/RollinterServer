
package net.ausiasmarch.rollinter.helper;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import net.ausiasmarch.rollinter.exception.ValidationException;

public class ValidationHelper {

    public static final String EMAIL_PATTERN = "^.+@.+\\..+$";
    public static final String CODIGO_PATTERN = "^([A-Z0-9]{1,6}-)[A-Za-z0-9]{5,200}$";

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void validateStringLength(String strNombre, int minlength, int maxlength, String error) {
        if (strNombre.length() >= minlength && strNombre.length() <= maxlength) {
        } else {
            throw new ValidationException("error en la validación: " + error);
        }
    }

    public static boolean validatePattern(String strInput, String strPattern) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(strPattern);
        java.util.regex.Matcher m = p.matcher(strInput);
        return m.matches();
    }


    public static void validateEmail(String email, String error) {
        validateStringLength(email, 3, 255, error);
        String ePattern = "^.+@.+\\..+$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new ValidationException("error de validación: " + error);
        }
    }

    public static void validateLogin(String strLogin, String error) {
        validateStringLength(strLogin, 6, 20, error);
        String ePattern = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){4,18}[a-zA-Z0-9]$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(strLogin);
        if (!m.matches()) {
            throw new ValidationException("error de validación: " + error);
        }
    }

    public static void validateRange(int iNumber, int iMin, int iMax, String error) {
        if (iNumber >= iMin && iNumber <= iMax) {
        } else {
            throw new ValidationException("error de validación: " + error);
        }
    }

    public static void validateRange(double iNumber, double iMin, double iMax, String error) {
        if (iNumber >= iMin && iNumber <= iMax) {
        } else {
            throw new ValidationException("error de validación: " + error);
        }
    }

    public static void validateDate(LocalDateTime oDate, LocalDateTime oDateStart, LocalDateTime oDateEnd, String error) {
        Long lDur1 = Duration.between(oDateStart, oDate).toMillis();
        Long lDur2 = Duration.between(oDate, oDateEnd).toMillis();
        if (lDur1 > 0L && lDur2 > 0L) {
        } else {
            throw new ValidationException("error de validación: " + error);
        }
    }

    public static void validateRPP(int iRPP) {
        if (iRPP < 1 || iRPP > 1000) {
            throw new ValidationException("RPP value is not valid (must be between 1 and 1000)");
        }
    }

    public static void validateYears (LocalDate userdate) {
        LocalDate actualdate = LocalDate.now();
        if ((actualdate.getYear() - userdate.getYear()) < 15){
            throw new ValidationException("You must be over 15 years old");
        }

    }

}
