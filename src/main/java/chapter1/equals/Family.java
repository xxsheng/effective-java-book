package chapter1.equals;

import java.io.Serializable;

public class Family implements Serializable {
    private String name;
    private Person members;

    public Family() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(Person members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public Person getMembers() {
        return members;
    }
}
