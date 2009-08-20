package org.yestech.rpx.auth;

import org.apache.commons.httpclient.HttpMethod;

/**
 * @author A.J. Wright
 */
public interface RPXAuthProvider {
    HttpMethod getMethod();
}
