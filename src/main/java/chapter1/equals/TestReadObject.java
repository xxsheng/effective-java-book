package chapter1.equals;

import java.io.*;

public class TestReadObject {

    static class Parent implements Serializable {
        private int value;

        public Parent(int value) {
            this.value = value;
        }

        protected void processValue() {
            System.out.println("Parent.processValue() called with value: " + value);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            processValue(); // 在readObject方法中调用可被覆盖方法
        }
    }

    static class Child extends Parent {
        public Child(int value) {
            super(value);
        }

        @Override
        protected void processValue() {
            System.out.println("Child.processValue() called with value: " + super.value);
        }
    }

        public static void main(String[] args) throws IOException, ClassNotFoundException {
            Child child = new Child(42);

            // 序列化对象
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(child);
            oos.close();

            // 反序列化对象
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Child deserializedChild = (Child) ois.readObject();
            ois.close();

            // 输出反序列化后的结果
            deserializedChild.processValue(); // 由于调用的是子类的processValue方法，会输出 "Child.processValue() called with value: 42"
        }

}
