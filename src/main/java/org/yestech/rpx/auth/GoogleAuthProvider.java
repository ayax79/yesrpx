package org.yestech.rpx.auth;

import static org.yestech.rpx.objectmodel.RPXUtil.uriEncode;

import static java.lang.String.format;

/**
 * @author A.J. Wright
 */
public class GoogleAuthProvider implements RPXAuthProvider {

    public static final String URL_PATTERN = "https://%s.rpxnow.com/openid/start?token_url=%s&openid_identifier=%s";
    public static final String GOOGLE_URL = uriEncode("https://www.google.com/accounts/o8/id");

    public String getRedirectUrl(String realm, String tokenUrl) {
        String encodedTokenUrl = uriEncode(tokenUrl);
        return format(URL_PATTERN, realm, encodedTokenUrl, GOOGLE_URL);
    }

}
