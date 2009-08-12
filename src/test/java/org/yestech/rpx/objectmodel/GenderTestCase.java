package org.yestech.rpx.objectmodel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.yestech.rpx.objectmodel.Gender.fromString;
import static org.yestech.rpx.objectmodel.Gender.MALE;
import static org.yestech.rpx.objectmodel.Gender.FEMALE;

/**
 * @author A.J. Wright
 */
public class GenderTestCase {

    @Test
    public void testUpperCaseMale() {
        assertEquals(MALE, fromString("MALE"));
    }

    @Test
    public void testUpperCaseFemale() {
        assertEquals(FEMALE, fromString("FEMALE"));
    }

    @Test
    public void testLowerCaseMale() {
        assertEquals(MALE, fromString("male"));
    }

    @Test
    public void testLowerCaseFemale() {
        assertEquals(FEMALE, fromString("female"));
    }

    @Test
    public void testUpperCaseM() {
        assertEquals(MALE, fromString("M"));
    }

    @Test
    public void testUpperCaseF() {
        assertEquals(FEMALE, fromString("F"));
    }

    @Test
    public void testLowerCaseM() {
        assertEquals(MALE, fromString("m"));
    }

    @Test
    public void testLowerCaseF() {
        assertEquals(FEMALE, fromString("f"));
    }

}
