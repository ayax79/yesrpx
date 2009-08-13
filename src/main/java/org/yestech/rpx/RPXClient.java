package org.yestech.rpx;

import org.yestech.rpx.objectmodel.AuthInfoResponse;

/**
 * @author A.J. Wright
 */
public interface RPXClient {
    AuthInfoResponse authInfo(String token, boolean extended) throws Exception;
}
