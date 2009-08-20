package org.yestech.rpx;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.json.JSONException;
import org.json.JSONObject;
import static org.yestech.rpx.RPXClient.Provider.GOOGLE;
import static org.yestech.rpx.RPXClient.Provider.MICROSOFT_LIVE;
import org.yestech.rpx.auth.GoogleAuthProvider;
import org.yestech.rpx.auth.MicrosoftLiveProvider;
import org.yestech.rpx.auth.RPXAuthProvider;
import org.yestech.rpx.objectmodel.AuthInfoResponse;
import org.yestech.rpx.objectmodel.GetContactsResponse;
import org.yestech.rpx.objectmodel.RPXException;
import org.yestech.rpx.objectmodel.RPXStat;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonString;

import java.io.IOException;

/**
 * @author A.J. Wright
 */
public class DefaultRPXClient implements RPXClient {

    private static final String RPX_API_URL = "https://rpxnow.com/api/v2/";

    private String apiKey;
    private String realm;

    public DefaultRPXClient(String apiKey, String realm) {
        this.apiKey = apiKey;
        this.realm = realm;
    }

    public AuthInfoResponse authInfo(String token, boolean extended) throws IOException, JSONException, RPXException {

        StringBuilder url = new StringBuilder(RPX_API_URL);
        url.append("auth_info");
        url.append("?token=").append(token);
        url.append("&apiKey=").append(apiKey);
        url.append("&extended=").append(extended);

        HttpClient client = getHttpClient();
        GetMethod get = new GetMethod(url.toString());
        try {
            client.executeMethod(get);
            String body = get.getResponseBodyAsString();
            JSONObject jo = new JSONObject(body);
            RPXException ex = RPXException.fromJSON(jo);
            if (ex != null) throw ex; // if the response was an exception throw it.

            // If not continue on
            return AuthInfoResponse.fromJson(jo);
        } finally {
            get.releaseConnection();
        }
    }

    public RPXStat map(String identifier, String primaryKey, boolean overwrite) throws IOException, JSONException, RPXException {

        StringBuilder url = new StringBuilder(RPX_API_URL);
        url.append("map");
        url.append("?identifier=").append(identifier);
        url.append("&primaryKey=").append(primaryKey);
        url.append("&overwrise=").append(overwrite);

        HttpClient client = getHttpClient();
        GetMethod get = new GetMethod(url.toString());
        try {
            client.executeMethod(get);
            String body = get.getResponseBodyAsString();
            JSONObject jo = new JSONObject(body);
            RPXException ex = RPXException.fromJSON(jo);
            if (ex != null) throw ex;

            return RPXStat.fromString(jsonString(jo, "stat"));
        } finally {
            get.releaseConnection();
        }
    }

    public GetContactsResponse getContacts(String identifier) throws JSONException, IOException, RPXException {
        StringBuilder url = new StringBuilder(RPX_API_URL);
        url.append("get_contacts");
        url.append("?apiKey=").append(apiKey);
        url.append("&identifier=").append(identifier);

        HttpClient client = getHttpClient();
        GetMethod get = new GetMethod(url.toString());
        client.executeMethod(get);
        String body = get.getResponseBodyAsString();
        JSONObject jo = new JSONObject(body);
        RPXException ex = RPXException.fromJSON(jo);
        if (ex != null) throw ex;

        return GetContactsResponse.fromJson(jo);
    }

    public String buildAuthRedirect(Provider provider, String tokenUrl) throws IOException {

        if (provider == MICROSOFT_LIVE) {
            return buildAuthRedirect(new MicrosoftLiveProvider(), tokenUrl);
        }
        else if (provider == GOOGLE) {
            return buildAuthRedirect(new GoogleAuthProvider(), tokenUrl);

        }
        throw new IllegalArgumentException("unknown provider"+provider); //shouldn't happen
    }

    public String buildAuthRedirect(RPXAuthProvider provider, String tokenUrl) {
        return provider.getRedirectUrl(realm, tokenUrl);
    }


    protected HttpClient getHttpClient() {
        return new HttpClient();
    }

}
