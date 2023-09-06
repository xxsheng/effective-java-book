package chapter1;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person {

    private final Date birthDate;

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBabyBoomer() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1946, Calendar.JANUARY,1,0,0,0);
        Date startTime = calendar.getTime();
        calendar.set(1965, Calendar.JANUARY, 1, 0,0,0);
        Date endTime = calendar.getTime();
        return birthDate.compareTo(startTime) >= 0 && birthDate.compareTo(endTime) < 0;
    }
}
