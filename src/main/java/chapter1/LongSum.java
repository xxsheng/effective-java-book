package chapter1;

public class LongSum {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        sumBoxing();
        sumUnBoxing();
    }

    /**
     * bad case
     * @return
     */
    public static Long sumBoxing() {
        long startTime = System.currentTimeMillis();
        // bad case
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum = sum + i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return sum;
    }

    public static Long sumUnBoxing() {
        long startTime = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum = sum + i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return sum;
    }
}
