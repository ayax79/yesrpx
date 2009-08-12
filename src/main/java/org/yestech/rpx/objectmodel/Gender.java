package org.yestech.rpx.objectmodel;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author A.J. Wright
 */
@XmlRootElement(name = "gender")
public enum Gender {
    MALE,
    FEMALE;

    public static Gender fromString(String gender) {
        if (gender == null) {
            return null;
        } else if ("male".equalsIgnoreCase(gender)) {
            return MALE;
        } else if ("female".equalsIgnoreCase(gender)) {
            return FEMALE;
        } else if ("M".equalsIgnoreCase(gender)) {
            return MALE;
        } else if ("F".equalsIgnoreCase(gender)) {
            return FEMALE;
        }
        return null;
    }

}
