package org.yestech.rpx.objectmodel;

/**
 * @author A.J. Wright
 */
public enum RPXStat {
    OK;

    public static RPXStat fromString(String s) {
        if ("ok".equalsIgnoreCase(s)) {
            return OK;
        }
        return null;
    }
}
