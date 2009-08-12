package org.yestech.rpx.objectmodel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.json.JSONObject;
import org.json.JSONException;

/**
 * @author A.J. Wright
 */
public class EmailTest {
    @Test
    public void testFromJson() throws JSONException {
        String json = "{\n" +
                "        \"type\": \"other\",\n" +
                "        \"value\": \"ayax79@gmail.com\"\n" +
                "      }";

        JSONObject object = new JSONObject(json);
        Email email = Email.fromJson(object);
        assertEquals("ayax79@gmail.com", email.getValue());
        assertEquals("other", email.getType());
    }
}
