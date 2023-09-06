package chapter1.equals;

import java.sql.Timestamp;
import java.util.Date;

public class TestEquals {
    public static void main(String[] args) {
        Date date = new Date();
        Timestamp ts1 = new Timestamp(date.getTime());

        System.out.println(date.equals(ts1));
        System.out.println(ts1.equals(date));

    }







    public static class Timestamp1 extends java.sql.Timestamp {

        public Timestamp1(long time) {
            super(time);
        }

        @Override
        public boolean equals(Object ts) {
            if (ts instanceof java.sql.Timestamp) {
                return this.equals((java.sql.Timestamp)ts);
            } else if (ts instanceof Date) {
                return this.getTime() == ((Date) ts).getTime();
            } else {
                return false;
            }
        }
    }
}
