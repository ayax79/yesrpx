package org.yestech.rpx.objectmodel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.json.JSONObject;
import org.json.JSONException;

/**
 * @author A.J. Wright
 */
public class RPXExceptionTest {

    @SuppressWarnings({"ThrowableResultOfMethodCallIgnored"})
    @Test
    public void testFromJSON() throws JSONException {
        String json = "{\n" +
                "  \"err\": {\n" +
                "    \"msg\": \"Data not found\",\n" +
                "    \"code\": 2\n" +
                "  },\n" +
                "  \"stat\": \"fail\"\n" +
                "}";
        RPXException ex = RPXException.fromJSON(new JSONObject(json));
        assertEquals("Data not found", ex.getMessage());
        assertEquals(2, ex.getCode());
        assertEquals(RPXStat.FAIL, ex.getStat());
    }
}
