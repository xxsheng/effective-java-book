package chapter1.clone;

import java.util.AbstractMap;

public abstract class AbstractClone {

    protected Object clone() throws CloneNotSupportedException {
        Object result = super.clone();
        return result;
    }
}

class Clone extends AbstractClone {

}
