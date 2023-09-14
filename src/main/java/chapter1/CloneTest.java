package chapter1;

public class CloneTest implements Cloneable {

    // clone 方法无法重新赋值，只能引用被克隆对象的
    private final Object o = new Object();

    int a = 99;

    public CloneTest() {
    }

    public CloneTest(int a) {
        this.a = a;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest cloneTest = new CloneTest();
        Object clone = cloneTest.clone();
        System.out.println("--");
    }

    @Override
    protected CloneTest clone() throws CloneNotSupportedException {
        return new CloneTest(20);
    }

}
