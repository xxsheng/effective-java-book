package equals;

import java.sql.Timestamp;
import java.util.Date;

public class MyTimestamp extends Timestamp {

    public MyTimestamp(long time) {
        super(time);
    }

    @Override
    public boolean equals(Object ts) {
        if (ts instanceof Timestamp) {
            return this.equals((Timestamp)ts);
        } else if (ts instanceof Date) {
            return this.getTime() == ((Date) ts).getTime();
        } else {
            return false;
        }
    }
}
