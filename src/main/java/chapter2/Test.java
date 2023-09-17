package chapter2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

     // package field
     int a;
     int b;

     // potential security hole
     public static final Thing[] VALUES = {};

     private static final Thing[] PRIVATE_VALUES = {};
     public static final List<Thing> VALUES_1 = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

     public static Thing[] values() {
          return PRIVATE_VALUES.clone();
     }

     static class Thing {

     }
}
