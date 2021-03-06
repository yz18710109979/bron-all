package com.jy.bron.core.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Common methods for exception.
 *
 * @author nkorange
 * @since 1.2.0
 */
public class ExceptionUtil {
    
    /**
     * Represents an empty exception, that is, no exception occurs, only a constant.
     */
    public static final Exception NONE_EXCEPTION = new RuntimeException("");
    
    public static String getAllExceptionMsg(Throwable e) {
        Throwable cause = e;
        StringBuilder strBuilder = new StringBuilder();
        
        while (cause != null && !StringUtils.isEmpty(cause.getMessage())) {
            strBuilder.append("caused: ").append(cause.getMessage()).append(";");
            cause = cause.getCause();
        }
        
        return strBuilder.toString();
    }
    
    public static Throwable getCause(final Throwable t) {
        final Throwable cause = t.getCause();
        if (Objects.isNull(cause)) {
            return t;
        }
        return cause;
    }
    
    public static String getStackTrace(final Throwable t) {
        if (t == null) {
            return "";
        }
        
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final PrintStream ps = new PrintStream(out);
        t.printStackTrace(ps);
        ps.flush();
        return new String(out.toByteArray());
    }
}
