package chapter1;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person1 {

    private final Date birthDate;

    private static final Date startTime;

    private static final Date endTime;

    public Person1(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(startTime) >= 0 && birthDate.compareTo(endTime) < 0;
    }

    static {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1946, Calendar.JANUARY,1,0,0,0);
        startTime = calendar.getTime();
        calendar.set(1965, Calendar.JANUARY, 1, 0,0,0);
        endTime = calendar.getTime();
    }
}
