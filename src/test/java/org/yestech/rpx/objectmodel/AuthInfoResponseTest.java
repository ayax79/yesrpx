package org.yestech.rpx.objectmodel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.apache.commons.io.IOUtil;
import org.json.JSONObject;
import org.json.JSONException;
import static org.yestech.rpx.objectmodel.RPXUtil.fromRPXDateString;
import static org.yestech.rpx.objectmodel.Gender.MALE;

import java.io.*;


/**
 * @author A.J. Wright
 */
public class AuthInfoResponseTest {
    @Test
    public void testMyOpenIdResponse() throws IOException, JSONException {

        InputStream in = getClass().getResourceAsStream("/aj-myopenid-authInfo.json");
        Reader reader = new InputStreamReader(in);
        StringWriter writer = new StringWriter();
        IOUtil.copy(reader, writer);
        JSONObject json = new JSONObject(writer.toString());
        AuthInfoResponse response = AuthInfoResponse.fromJson(json);

        assertEquals(fromRPXDateString("1979-01-09"), response.getSreg().getDob());
        assertEquals("A.J.", response.getSreg().getNickname());
        assertEquals("Andrew Wright", response.getSreg().getFullname());
        assertEquals(MALE, response.getSreg().getGender());
        assertEquals("ayax79@gmail.com", response.getSreg().getEmail());

        assertEquals("Andrew Wright", response.getProfile().getName().getFormatted());
        assertEquals("Andrew Wright", response.getProfile().getDisplayname());
        assertEquals("A.J.", response.getProfile().getPreferredUsername());
        assertEquals(MALE, response.getProfile().getGender());
        assertEquals(fromRPXDateString("1979-01-09"), response.getProfile().getBirthday());
        assertEquals("MyOpenID", response.getProfile().getProviderName() );
        assertEquals("http://ayax79.myopenid.com/", response.getProfile().getIdentifier());
        assertEquals("ayax79@gmail.com", response.getProfile().getEmail());

        assertEquals(MALE, response.getMergedPoco().getGender());
        assertEquals("other", response.getMergedPoco().getUrls().get(0).getType());
        assertEquals("http://ayax79.myopenid.com/", response.getMergedPoco().getUrls().get(0).getValue());
        assertEquals("A.J.", response.getMergedPoco().getPreferredUsername());
        assertEquals("Andrew Wright", response.getMergedPoco().getDisplayname());
        assertEquals("Andrew Wright", response.getMergedPoco().getName().getFormatted());
        assertEquals(fromRPXDateString("1979-01-09"), response.getMergedPoco().getBirthday());
        assertEquals("other", response.getMergedPoco().getEmails().get(0).getType());
        assertEquals("ayax79@gmail.com", response.getMergedPoco().getEmails().get(0).getValue());
        assertEquals(RPXStat.OK, response.getStat());
    }
}
