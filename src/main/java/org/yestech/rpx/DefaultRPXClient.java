package org.yestech.rpx;

import org.yestech.rpx.objectmodel.AuthInfoResponse;
import org.yestech.rpx.objectmodel.RPXException;
import org.yestech.rpx.objectmodel.RPXStat;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonString;
import org.json.JSONObject;
import org.json.JSONException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

/**
 * @author A.J. Wright
 */
public class DefaultRPXClient implements RPXClient {

    private static final String RPX_API_URL = "https://rpxnow.com/api/v2/";

    private String apiKey;

    public DefaultRPXClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public AuthInfoResponse authInfo(String token, boolean extended) throws IOException, JSONException, RPXException {

        StringBuilder url = new StringBuilder(RPX_API_URL);
        url.append("auth_info");
        url.append("?token=").append(token);
        url.append("&apiKey=").append(apiKey);
        url.append("&extended=").append(extended);

        HttpClient client = new HttpClient();
        GetMethod get = new GetMethod(url.toString());
        client.executeMethod(get);
        String body = get.getResponseBodyAsString();
        JSONObject jo = new JSONObject(body);
        RPXException ex = RPXException.fromJSON(jo);
        if (ex != null) throw ex; // if the response was an exception throw it.

        // If not continue on
        return AuthInfoResponse.fromJson(jo);
    }

    public RPXStat map(String identifier, String primaryKey, boolean overwrite) throws IOException, JSONException, RPXException {

        StringBuilder url = new StringBuilder(RPX_API_URL);
        url.append("map");
        url.append("?identifier=").append(identifier);
        url.append("&primaryKey=").append(primaryKey);
        url.append("&overwrise=").append(overwrite);

        HttpClient client = new HttpClient();
        GetMethod get = new GetMethod(url.toString());
        client.executeMethod(get);
        String body = get.getResponseBodyAsString();
        JSONObject jo = new JSONObject(body);
        RPXException ex = RPXException.fromJSON(jo);
        if (ex != null) throw ex;

        return RPXStat.fromString(jsonString(jo, "stat"));
    }

}
