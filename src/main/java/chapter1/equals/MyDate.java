package chapter1.equals;

import java.io.Serializable;
import java.util.Date;

public class MyDate extends Date implements Serializable {
    private String abc;
    public MyDate(String abc) {
        this.abc = abc;
        System.out.println("---");
    }
    public static void main(String[] args) {
        MyDate myDate = new MyDate("abc");
        Object clone = myDate.clone();
        System.out.println(clone);
    }

    private Object readResolve() {
        return new MyDate("1234");
    }
}
