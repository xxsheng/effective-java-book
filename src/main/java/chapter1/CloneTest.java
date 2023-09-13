package chapter1;

public class CloneTest implements Cloneable{

    private Object o = new Object();

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest cloneTest = new CloneTest();
        Object clone = cloneTest.clone();
        System.out.println("--");
    }
}
