package org.yestech.rpx.objectmodel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.json.JSONObject;
import org.json.JSONException;

/**
 * @author A.J. Wright
 */
public class UrlTest {

    @Test
    public void testFromJson() throws JSONException {
        String json = "{\n" +
                "        \"type\": \"other\",\n" +
                "        \"value\": \"http:\\/\\/ayax79.myopenid.com\\/\"\n" +
                "      }";


        Url result = Url.fromJson(new JSONObject(json));
        assertEquals("other", result.getType());
        assertEquals("http://ayax79.myopenid.com/", result.getValue());
    }
    
}
