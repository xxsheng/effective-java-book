package chapter1;

import org.ietf.jgss.Oid;

import java.util.Arrays;

public class Stack1 {

    Object[] elementData;

    private final static int DEFAULT_SIZE = 16;

    private int size;

    public Stack1() {
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
        elementData[size] = null;
        return object;
    }
}
