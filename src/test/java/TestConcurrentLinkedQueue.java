import org.junit.Test;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TestConcurrentLinkedQueue {

    @Test
    public synchronized void testAdd() throws NoSuchFieldException, IllegalAccessException {

        ConcurrentLinkedQueue<Object> strings = new ConcurrentLinkedQueue<>();
        strings.offer(new Object());
        Field head = strings.getClass().getDeclaredField("head");
        head.setAccessible(true);
        Object o = head.get(strings);
        Field tail = strings.getClass().getDeclaredField("tail");
        tail.setAccessible(true);
        Object o1 = tail.get(strings);
        strings.add("1233");
        System.out.println("--");
    }

    @Test
    public void test2() {
        ConcurrentLinkedQueue<String> strings = new ConcurrentLinkedQueue<>();
        strings.add("aaa");
        strings.add("aaa1");
        strings.remove("aaa1");
    }
}
