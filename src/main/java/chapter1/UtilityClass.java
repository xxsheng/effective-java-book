package chapter1;

public class UtilityClass {
    // 工具类不可实例化
    private UtilityClass() {
        throw new Error();
    }

    public static void main(String[] args) {
        WeakReferenceTest sss = new WeakReferenceTest(new String("sss"));
        System.out.println(sss.get());
        System.gc();
        System.out.println(sss.get());
    }
}
