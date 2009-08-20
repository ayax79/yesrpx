package org.yestech.rpx.auth;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import static org.yestech.rpx.objectmodel.RPXUtil.uriEncode;

/**
 * @author A.J. Wright
 */
public class MicrosoftLiveProvider implements RPXAuthProvider {

    public static final String URL_PATTERN = "https://%s.rpxnow.com/liveid/start?token_url=%s";
    private String realm;
    private String tokenUrl;

    /**
     * Auth provider for microsoft live.
     *
     * @param realm The realm (ie. blackbox-republic).
     * @param tokenUrl The callback url that will process the rpx response.
     */
    public MicrosoftLiveProvider(String realm, String tokenUrl) {
        this.realm = realm;
        this.tokenUrl = tokenUrl;
    }

    @Override
    public HttpMethod getMethod() {
        String url = String.format(URL_PATTERN, realm, uriEncode(tokenUrl));
        return new PostMethod(url);
    }
}
