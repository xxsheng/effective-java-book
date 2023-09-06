package chapter1.equals;

import java.io.*;

public class Person implements Serializable {
    private String name;
    private Family family;

    public Person(String name, Family family) {
        this.name = name;
        this.family = family;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    private Object writeReplace() {
        return new PersonSerializableProxy(this);
    }

    public static class PersonSerializableProxy implements Serializable{
        private String name;
        private String familyName;
        private Family family;

        public PersonSerializableProxy(Person person) {
            this.name = person.name;
            this.family = person.getFamily();
            this.familyName = family.getName();
        }

        private Object readResolve() {
            // 会导致循环依赖，产生ClassCastException
            Person person = new Person(name, family);
            System.out.println(person.getName());
            return person;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setName("222");

        Family family = new Family();
        family.setName("333");

        person.setFamily(family);

        family.setMembers(person);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/xiaxiuqiang/Documents/xxq_document/03_document/5.text"));
        objectOutputStream.writeObject(person);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/xiaxiuqiang/Documents/xxq_document/03_document/5.text"));
        Person person1 = (Person) objectInputStream.readObject();
        System.out.println(person1);
    }
}
