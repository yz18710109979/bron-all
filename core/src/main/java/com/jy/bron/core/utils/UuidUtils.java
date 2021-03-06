package com.jy.bron.core.utils;

import java.util.UUID;

/**
 * UUID utils.
 *
 * @author nkorange
 */
public class UuidUtils {
    
    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
