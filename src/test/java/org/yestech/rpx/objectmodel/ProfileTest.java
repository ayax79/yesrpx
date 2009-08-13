package org.yestech.rpx.objectmodel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.json.JSONObject;
import org.json.JSONException;
import static org.yestech.rpx.objectmodel.RPXUtil.fromRPXDateString;

/**
 * @author A.J. Wright
 */
public class ProfileTest {
    @Test
    public void testFromJson() throws JSONException {

        String json = "{\n" +
                "    \"name\": {\n" +
                "      \"formatted\": \"Andrew Wright\"\n" +
                "    },\n" +
                "    \"displayName\": \"Andrew Wright\",\n" +
                "    \"preferredUsername\": \"A.J.\",\n" +
                "    \"url\": \"http:\\/\\/ayax79.myopenid.com\\/\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"birthday\": \"1979-01-09\",\n" +
                "    \"providerName\": \"MyOpenID\",\n" +
                "    \"identifier\": \"http:\\/\\/ayax79.myopenid.com\\/\",\n" +
                "    \"email\": \"ayax79@gmail.com\"\n" +
                "  }";


        Profile profile = Profile.fromJson(new JSONObject(json));
        assertEquals(fromRPXDateString("1979-01-09"), profile.getBirthday());
        assertEquals("Andrew Wright", profile.getName().getFormatted());
        assertEquals("Andrew Wright", profile.getDisplayname());
        assertEquals("A.J.", profile.getPreferredUsername());
        assertEquals("http://ayax79.myopenid.com/", profile.getUrl());
        assertEquals(Gender.MALE, profile.getGender());
        assertEquals("MyOpenID", profile.getProviderName());
        assertEquals("http://ayax79.myopenid.com/", profile.getIdentifier());
        assertEquals("ayax79@gmail.com", profile.getEmail());
    }

    @Test
    public void testNone() throws JSONException {
        Profile p = Profile.fromJson(new JSONObject("{}"));
        assertNotNull(p);
    }

}
