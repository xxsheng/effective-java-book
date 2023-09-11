import chapter1.equals.MyTimestamp;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Objects;

public class TestMyTimestamp {

    @Test
    public void test() {
        Date date = new Date();
        MyTimestamp myTimestamp = new MyTimestamp(date.getTime());

        assert date.equals(myTimestamp);
        assert myTimestamp.equals(date);
    }

    @Test
    public void testEquals() {
        Date date = new Date();
        MyTimestamp myTimestamp1 = new MyTimestamp(date.getTime());

        // myTimestamp2 和myTimeStamp1的区别是多了1纳秒
        MyTimestamp myTimestamp2 = new MyTimestamp(date.getTime());
        myTimestamp2.setNanos(myTimestamp2.getNanos()+1);

        assert date.equals(myTimestamp1);
        assert myTimestamp1.equals(date);

        assert date.equals(myTimestamp2);
        assert myTimestamp2.equals(date);

        assert myTimestamp1.equals(myTimestamp2);
    }

    @Test
    public void test1() throws MalformedURLException {
        URL url = new URL("http://www.baidu.com");
    }

    @Test
    public void test2() {
        Float a = Float.NaN;
        Float b = Float.NaN;
        System.out.println(a);
        System.out.println(a == b);
        System.out.println(Objects.equals(Float.NaN, Float.NaN));
    }

    @Test
    public void test3(){
        System.out.println(Double.doubleToLongBits(1.1));
    }

}
