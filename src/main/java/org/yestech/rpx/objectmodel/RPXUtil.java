package org.yestech.rpx.objectmodel;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONArray;

/**
 * @author A.J. Wright
 */
public final class RPXUtil {

    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");

    public static DateTime fromRPXDateString(String string) {
        if (string == null) return null;
        return formatter.parseDateTime(string);
    }

    public static String toRPXDateString(DateTime dt) {
        return dt.toString(formatter);
    }

    public static String jsonString(JSONObject jo, String property) {
        try {
            if (jo != null) return jo.getString(property);
        } catch (JSONException e) {
            // ignore the exception
        }
        return null;
    }

    public static JSONArray jsonArray(JSONObject jo, String property) {
        try {
            if (jo != null) return jo.getJSONArray(property);
        } catch (JSONException e) {
            // ignore the exception
        }
        return null;
    }

    public static JSONObject jsonObject(JSONObject jo, String property) {
        try {
            if (jo != null) return jo.getJSONObject(property);
        } catch (JSONException e) {
            // ignore the exception
        }
        return null;
    }

    public static int jsonInt(JSONObject jo, String property) {
        try {
            if (jo != null) return jo.getInt(property);
        } catch (JSONException e) {
            // ignore the exception
        }
        return 0;
    }

    public static JSONObject jsonObject(JSONArray array, int index) {
        try {
            if (array != null) return array.getJSONObject(index);
        } catch (JSONException e) {
            // ignore the exception
        }
        return null;
    }

    public static String jsonString(JSONArray array, int index) {
        try {
            if (array != null) return array.getString(index);
        } catch (JSONException e) {
            // ignore the exception
        }
        return null;
    }

}
