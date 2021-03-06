package com.jy.bron.core.utils;

/**
 * Nacos number util.
 *
 * @author xiweng.yy
 */
public class NumberUtil {
    
    /**
     * Whether all chars of input string is digit.
     *
     * @param input {@code String} checked
     * @return {@code true} if all chars is digit, otherwise false
     */
    public static boolean isDigits(String input) {
        if (StringUtils.isEmpty(input)) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
}
