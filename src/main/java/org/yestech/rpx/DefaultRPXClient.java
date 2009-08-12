package org.yestech.rpx;

import org.yestech.rpx.objectmodel.AuthInfoResponse;
import org.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * @author A.J. Wright
 */
public class DefaultRPXClient implements RPXClient {

    private static final String AUTH_INFO_URL = "https://rpxnow.com/api/v2/auth_info";

    private String apiKey;

    public DefaultRPXClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public AuthInfoResponse authInfo(String token) throws Exception {
        HttpClient client = new HttpClient();
        GetMethod get = new GetMethod(String.format("https://rpxnow.com/api/v2/auth_info?token=%s&apiKey=%s",
                token,
                apiKey));
        client.executeMethod(get);
        String body = get.getResponseBodyAsString();
        JSONObject jo = new JSONObject(body);


        return null;
    }

}
