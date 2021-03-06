package com.jy.bron.core.utils;

import java.lang.reflect.Field;

/**
 * reflect utils.
 *
 * @author liuzunfei
 * @version $Id: ReflectUtils.java, v 0.1 2020年08月20日 12:57 PM liuzunfei Exp $
 */
public class ReflectUtils {
    
    /**
     * get filed value of  obj.
     *
     * @param obj       obj.
     * @param fieldName file name to get value.
     * @return
     */
    public static Object getFieldValue(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * get filed value of  obj.
     *
     * @param obj       obj.
     * @param fieldName file name to get value.
     * @return
     */
    public static Object getFieldValue(Object obj, String fieldName, Object defaultValue) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            return defaultValue;
        }
    }
    
}
