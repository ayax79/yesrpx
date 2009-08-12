package org.yestech.rpx;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.yestech.rpx.objectmodel.AuthInfoResponse;

import javax.ws.rs.core.MediaType;
import java.awt.*;

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
        ClientRequest request = new ClientRequest(AUTH_INFO_URL);
        //request.getProviderFactory().addMessageBodyReader();
        request.accept(MediaType.APPLICATION_JSON_TYPE);
        request.setHttpMethod("get");
        request.getQueryParameters().add("token", token);
        request.getQueryParameters().add("apiKey", apiKey);
        ClientResponse<AuthInfoResponse> result = request.get(AuthInfoResponse.class);
        return result.getEntity();
    }
                                                                                                                                                                                        

}
