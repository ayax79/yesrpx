package org.yestech.rpx;

import org.yestech.rpx.objectmodel.AuthInfoResponse;
import org.yestech.rpx.objectmodel.RPXStat;
import org.yestech.rpx.objectmodel.RPXException;
import org.json.JSONException;

import java.io.IOException;

/**
 * @author A.J. Wright
 */
public interface RPXClient {
    AuthInfoResponse authInfo(String token, boolean extended) throws Exception;

    RPXStat map(String identifier, String primaryKey, boolean overwrite) throws IOException, JSONException, RPXException;
}
