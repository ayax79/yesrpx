package org.yestech.rpx.objectmodel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.json.JSONException;

/**
 * @author A.J. Wright
 */
public class RPXUtilTest {

    @Test
    public void testFromString() {
        String s = "1999-12-31";

        DateTime dt = RPXUtil.fromRPXDateString(s);
        assertEquals(1999, dt.getYear());
        assertEquals(12, dt.getMonthOfYear());
        assertEquals(31, dt.getDayOfMonth());
    }

    @Test
    public void testToString() {
        DateTime dt = new DateTime(1999, 12, 31, 0, 0, 0, 0);
        String s = RPXUtil.toRPXDateString(dt);
        assertEquals("1999-12-31", s);
    }


    @Test
    public void testJsonString() throws JSONException {
        String json = "{ foo: \"bar\" }";
        JSONObject jo = new JSONObject(json);
        String result = RPXUtil.jsonString(jo, "foo");
        assertEquals("bar", result);
    }

    @Test
    public void testJsonStringNull() throws JSONException {
        String json = "{ foo: \"bar\" }";
        JSONObject jo = new JSONObject(json);
        String result = RPXUtil.jsonString(jo, "baz");
        assertNull(result);
    }
}
