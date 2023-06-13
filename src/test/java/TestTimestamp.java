import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

public class TestTimestamp {

    @Test
    public void testEquals() {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        Assert.assertEquals("date.equals(ts) is false", date, ts);
        Assert.assertEquals("ts.equals(date) is false", ts, date);
    }
}
