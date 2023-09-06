package chapter1.equals;

import java.io.*;

public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();

    private MyDate myDate;

    public void setMyDate(MyDate myDate) {
        this.myDate = myDate;
    }

    private Elvis() {
        System.out.println("---");
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Elvis elvis = Elvis.INSTANCE;
//        elvis.setMyDate(new MyDate("456"));
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/xiaxiuqiang/Documents/xxq_document/03_document/2.text"));
//        objectOutputStream.writeObject(elvis);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/xiaxiuqiang/Documents/xxq_document/03_document/2.text"));
        Object o = objectInputStream.readObject();
    }

}
