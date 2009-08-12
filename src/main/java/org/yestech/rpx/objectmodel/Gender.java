package org.yestech.rpx.objectmodel;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author A.J. Wright
 */
@XmlRootElement(name = "gender")
public enum Gender {
    MALE,
    FEMALE
}
