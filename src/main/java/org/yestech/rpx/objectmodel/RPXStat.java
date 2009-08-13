package org.yestech.rpx.objectmodel;

/**
 * @author A.J. Wright
 */
public enum RPXStat {
    OK,
    FAIL;

    public static RPXStat fromString(String s) {
        if ("ok".equalsIgnoreCase(s)) {
            return OK;
        }
        else if ("fail".equalsIgnoreCase(s)) {
            return FAIL;
        }
        return null;
    }
}
