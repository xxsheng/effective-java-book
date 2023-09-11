package chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * symmetry 对称性
 */
public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.s = s;
    }

    /**
     * broken violates symmetry
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
        }

        if (obj instanceof String) {
            return s.equalsIgnoreCase((String) obj);
        }

        return false;

        // 想要避免违反对称性。需要移除对string的兼容
//        return obj instanceof CaseInsensitiveString && ((CaseInsensitiveString) obj).s.equalsIgnoreCase(this.s);
    }

    public static void main(String[] args) {
        List<CaseInsensitiveString> caseInsensitiveStringList = new ArrayList<>();
        caseInsensitiveStringList.add(new CaseInsensitiveString("Polish"));
        String s = "polish";
        // 此处以s为基准去比较equals
        System.out.println(caseInsensitiveStringList.contains(s));
    }
}
