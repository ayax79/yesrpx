package org.yestech.rpx.objectmodel;

import org.json.JSONObject;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonObject;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonInt;
import static org.yestech.rpx.objectmodel.RPXUtil.jsonString;

/**
 * @author A.J. Wright
 */
public class RPXException extends Exception {

    private int code;
    private RPXStat stat;

    public RPXException(String message, int code, RPXStat stat) {
        super(message);
        this.code = code;
        this.stat = stat;
    }

    public int getCode() {
        return code;
    }

    public RPXStat getStat() {
        return stat;
    }

    /**
     * Will return an rpx exception if one exists.
     *
     * @param json The json object.
     * @return The exception created from the json string, null if there is no exception.
     */
    public static RPXException fromJSON(JSONObject json) {
        JSONObject err = jsonObject(json, "err");
        if (err == null) return null;

        int code = jsonInt(err, "code");
        String msg = jsonString(err, "msg");
        RPXStat stat = RPXStat.fromString(jsonString(json, "stat"));
        return new RPXException(msg, code, stat);
    }
}
