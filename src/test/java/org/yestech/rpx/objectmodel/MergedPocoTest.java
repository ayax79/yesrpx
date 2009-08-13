package org.yestech.rpx.objectmodel;

import org.joda.time.DateTime;
import org.json.JSONObject;
import org.json.JSONException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import java.util.List;

/**
 * @author A.J. Wright
 */
public class MergedPocoTest {

    @Test
    public void testFromJson() throws JSONException {
        String json = "{\n" +
                "    \"gender\": \"male\",\n" +
                "    \"urls\": [\n" +
                "      {\n" +
                "        \"type\": \"other\",\n" +
                "        \"value\": \"http:\\/\\/ayax79.myopenid.com\\/\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"preferredUsername\": \"A.J.\",\n" +
                "    \"displayName\": \"Andrew Wright\",\n" +
                "    \"name\": {\n" +
                "      \"formatted\": \"Andrew Wright\"\n" +
                "    },\n" +
                "    \"birthday\": \"1979-01-09\",\n" +
                "    \"emails\": [\n" +
                "      {\n" +
                "        \"type\": \"other\",\n" +
                "        \"value\": \"ayax79@gmail.com\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }";

        MergedPortableContact mp = MergedPortableContact.fromJson(new JSONObject(json));
        assertEquals(mp.getGender(), mp.getGender());
        List<Url> list = mp.getUrls();
        assertNotNull(list);
        assertEquals(1, list.size());
        Url url = list.get(0);
        assertEquals("other", url.getType());
        assertEquals("http://ayax79.myopenid.com/", url.getValue());
        assertEquals("A.J.", mp.getPreferredUsername());
        assertEquals("Andrew Wright", mp.getDisplayname());
        assertNotNull(mp.getName());
        assertEquals("Andrew Wright", mp.getName().getFormatted());
        DateTime birthday = mp.getBirthday();
        assertNotNull(birthday);

        assertEquals(9, birthday.getDayOfMonth());
        assertEquals(1, birthday.getMonthOfYear());
        assertEquals(1979, birthday.getYear());

        List<Email> emails = mp.getEmails();
        assertNotNull(emails);
        assertEquals(1, emails.size());
        Email email = emails.get(0);
        assertNotNull(email);
        assertEquals("other", email.getType());
        assertEquals("ayax79@gmail.com", email.getValue());
    }

}
