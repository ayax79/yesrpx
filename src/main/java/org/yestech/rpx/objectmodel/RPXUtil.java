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

    /**
     * Escape HTTP URI fragment per RFC2396
     *
     * @param uri Url to encode.
     * @return The encoded url.
     */
    public static String uriEncode(String uri) {
        int length = uri.length();

        if (length == 0)
            return uri;

        StringBuffer results = new StringBuffer();

        for (int i = 0;
             i < length;
             i++) {
            char c = uri.charAt(i);
            switch (c) {
                case ';':
                case '/':
                case '?':
                case ':':
                case '@':
                case '&':
                case '=':
                case '+':
                case '$':
                case ',':
                case '%':
                    // Note:  Space and double quote are not specified by
                    //        RFC2396..., but we need 'em anyway...
                case ' ':
                case '"':
                    try {
                        byte[] octets;
                        octets = uri.substring(i, i + 1).getBytes();
                        //noinspection ForLoopReplaceableByForEach
                        for (int j = 0;
                             j < octets.length;
                             j++) {
                            String hexVal = Integer.toHexString(octets[j]).toUpperCase();
                            if (hexVal.length() == 2) {
                                results.append("%").append(hexVal);
                            } else {
                                results.append("%0").append(hexVal);
                            }
                        }
                    } catch (Exception e) {
                    }

                    break;
                default:
                    results.append(c);
                    break;
            }
        }

        return results.toString();
    }


}
