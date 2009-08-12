package org.yestech.rpx;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.yestech.rpx.objectmodel.AuthInfoResponse;

/**
 * @author A.J. Wright
 */
public class DefaultRPXClient {

    private static final String AUTH_INFO_URL = "https://rpxnow.com/api/v2/auth_info";

    private String apiKey;

    public DefaultRPXClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public AuthInfoResponse authInfo(String token) throws Exception {
        ClientRequest request = new ClientRequest(AUTH_INFO_URL);
        request.setHttpMethod("get");
        request.getQueryParameters().add("token", token);
        request.getQueryParameters().add("apiKey", apiKey);
        ClientResponse<AuthInfoResponse> result = request.get(AuthInfoResponse.class);
        return result.getEntity();
    }


}
