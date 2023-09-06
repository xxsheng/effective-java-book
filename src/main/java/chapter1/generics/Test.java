package chapter1.generics;

import java.util.*;

public class Test {

    public static <T extends Comparable<? super T>> T max(Collection<T> list) {

        Iterator<T> iterator = list.iterator();
        T next = iterator.next();
        return null;
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat());
        animals.add(new Dog());
        max(animals);

//        List<Dog> dogs = new ArrayList<>();
//        dogs.add(new Dog());
//        max(dogs);
    }

    static class Animal  implements Comparable<Animal>{
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Animal o) {
            return age - o.getAge();
        }
    }

    static class Dog extends Animal {
        private int field1;


    }

    static class Cat extends Animal {
        private int field2;
    }
}
