package chapter1.equals;

import java.io.*;

public class SupperClass implements Serializable {
    private String type;
    public SupperClass(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    private Object writeReplace() {
        return new SuperClassProxy(this);
    }

    public static class SuperClassProxy implements Serializable{
        private String type;

        public SuperClassProxy(SupperClass supperClass) {
            this.type = supperClass.getType();
        }

        private Object readResolve() {
            return new SupperClass(type);
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SupperClass test1 = new SupperClass("test1");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/xiaxiuqiang/Documents/xxq_document/03_document/3.text"));
        objectOutputStream.writeObject(test1);
//
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/xiaxiuqiang/Documents/xxq_document/03_document/3.text"));
//        Object o = objectInputStream.readObject();
//        System.out.println("--");
//        SubClass test2 = new SubClass("test2");
//
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/xiaxiuqiang/Documents/xxq_document/03_document/4.text"));
//        objectOutputStream.writeObject(test2);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/xiaxiuqiang/Documents/xxq_document/03_document/3.text"));
        SubClass o = (SubClass)objectInputStream.readObject();
        System.out.println("--");

    }



    static class SubClass extends SupperClass implements Serializable{

        private String abc = "34324";
        public SubClass(String type) {
            super(type);
        }
    }
}
