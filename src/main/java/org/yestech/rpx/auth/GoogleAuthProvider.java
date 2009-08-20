package org.yestech.rpx.auth;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import static org.yestech.rpx.objectmodel.RPXUtil.uriEncode;

import static java.lang.String.format;

/**
 * @author A.J. Wright
 */
public class GoogleAuthProvider implements RPXAuthProvider {

    public static final String URL_PATTERN = "https://%s.rpxnow.com/openid/start?token_url=%s";
    public static final String GOOGLE_URL = "https://www.google.com/accounts/o8/id";

    private String realm;
    private String tokenUrl;

    /**
     * Auth provider for google.
     *
     * @param realm The realm (ie. blackbox-republic).
     * @param tokenUrl The callback url that will process the rpx response.
     */
    public GoogleAuthProvider(String realm, String tokenUrl) {
        this.realm = realm;
        this.tokenUrl = tokenUrl;
    }

    public HttpMethod getMethod() {
        String encodedTokenUrl = uriEncode(tokenUrl);
        String url = format(URL_PATTERN, realm, encodedTokenUrl);
        PostMethod method = new PostMethod(url);
        method.addParameter("openid_identifier", GOOGLE_URL);
        return method;
    }

}
