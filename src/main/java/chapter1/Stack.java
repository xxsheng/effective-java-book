package chapter1;

import java.util.Arrays;

public class Stack {

    Object[] elementData;

    private final static int DEFAULT_SIZE = 16;

    private int size;

    public Stack() {
        elementData = new Object[DEFAULT_SIZE];
    }

    public void push(Object e) {
        ensureCapacity();
        elementData[size++] = e;
    }

    private void ensureCapacity() {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, 2 * size +1);
        }
    }

    public Object pop() {
        Object object = elementData[--size];
        return object;
    }
}
