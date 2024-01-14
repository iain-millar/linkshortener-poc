package com.im.scratchpad.utils;

import java.util.regex.*;

/**
 * Helper class for Base62 encoding
 */
public class Base62Helper {

    //
    private static final char[] base62lookup = {'0','1','2','3','4','5','6','7','8','9'
            ,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
            ,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    /**
     * Encode a long value as a byte 62 string
     * @param originalValue Value which needs encoded in base62
     * @return base62 encoded value
     */
    public static String encode(long originalValue) {
        StringBuilder base62value = new StringBuilder();
        long currentQuotient = originalValue;
        int remainder;
        //Loop until quotient is no longer divisible by 62
        while (currentQuotient > 0) {
            remainder = (int) (currentQuotient % 62L);
            base62value.insert(0, base62lookup[remainder]);
            //Divide again to find next quotient
            currentQuotient = currentQuotient / 62L;
        }
        return base62value.toString();
    }

    /**
     * Is the provided string a valid base62 string
     * @param stringToValidate string to validated
     */
    public static boolean isValidBase62(String stringToValidate){
        //Build up base62 regex pattern
        String base62regex = "^[A-Za-z0-9]*$";
        Pattern base62pattern = Pattern.compile(base62regex);
        Matcher base62matcher = base62pattern.matcher(stringToValidate);
        // Return if the provided string matched base62 pattern
        return base62matcher.matches();
    }
}
