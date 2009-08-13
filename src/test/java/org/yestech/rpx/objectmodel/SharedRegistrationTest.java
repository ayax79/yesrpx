package org.yestech.rpx.objectmodel;

import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.yestech.rpx.objectmodel.RPXUtil.fromRPXDateString;

/**
 * @author A.J. Wright
 */
public class SharedRegistrationTest {

    @Test
    public void fromJsonTest() throws JSONException {
        String json = "{\n" +
                "    \"dob\": \"1979-01-09\",\n" +
                "    \"nickname\": \"A.J.\",\n" +
                "    \"fullname\": \"Andrew Wright\",\n" +
                "    \"gender\": \"M\",\n" +
                "    \"email\": \"ayax79@gmail.com\"\n" +
                "  }";

        SharedRegistration sreg = SharedRegistration.fromJson(new JSONObject(json));
        assertEquals(fromRPXDateString("1979-01-09"), sreg.getDob());
        assertEquals("A.J.", sreg.getNickname());
        assertEquals("Andrew Wright", sreg.getFullname());
        assertEquals(Gender.MALE, sreg.getGender());
        assertEquals("ayax79@gmail.com", sreg.getEmail());
    }

}
