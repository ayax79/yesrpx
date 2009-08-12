package org.yestech.rpx.objectmodel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.joda.time.DateTime;

/**
 * @author A.J. Wright
 */
public class RPXDateTimeUtilTest {

    @Test
    public void testFromString() {
        String s = "1999-12-31";

        DateTime dt = RPXDateTimeUtil.fromRPXDateString(s);
        assertEquals(1999, dt.getYear());
        assertEquals(12, dt.getMonthOfYear());
        assertEquals(31, dt.getDayOfMonth());
    }

    @Test
    public void testToString() {
        DateTime dt = new DateTime(1999, 12, 31, 0, 0, 0, 0);
        String s = RPXDateTimeUtil.toRPXDateString(dt);
        assertEquals("1999-12-31", s);
    }
}
