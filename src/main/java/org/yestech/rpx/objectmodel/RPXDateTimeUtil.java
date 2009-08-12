package org.yestech.rpx.objectmodel;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author A.J. Wright
 */
public final class RPXDateTimeUtil {

    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");

    public static DateTime fromRPXDateString(String string) {
        if (string == null) return null;
        return formatter.parseDateTime(string);
    }

    public static String toRPXDateString(DateTime dt) {
        return dt.toString(formatter);
    }

}
