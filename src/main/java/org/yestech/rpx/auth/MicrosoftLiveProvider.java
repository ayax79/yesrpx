package org.yestech.rpx.auth;

import static org.yestech.rpx.objectmodel.RPXUtil.uriEncode;

/**
 * @author A.J. Wright
 */
public class MicrosoftLiveProvider implements RPXAuthProvider {

    public static final String URL_PATTERN = "https://%s.rpxnow.com/liveid/start?token_url=%s";

    @Override
    public String getRedirectUrl(String realm, String tokenUrl) {
        return String.format(URL_PATTERN, realm, uriEncode(tokenUrl));
    }
}
