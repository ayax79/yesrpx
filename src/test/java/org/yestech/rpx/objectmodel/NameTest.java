package org.yestech.rpx.objectmodel;

import org.json.JSONObject;
import org.json.JSONException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author A.J. Wright
 */
public class NameTest {
    @Test
    public void testFromJson() throws JSONException {

        String json = "{\n" +
                "      \"formatted\": \"Andrew Wright\"\n" +
                "    }";

        Name name = Name.fromJson(new JSONObject(json));
        assertEquals("Andrew Wright", name.getFormatted());
    }
}
