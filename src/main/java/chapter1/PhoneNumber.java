package chapter1;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber implements Comparable<PhoneNumber>{

    private volatile  int hashcode;

    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = ((short) prefix);
        this.lineNumber = ((short) lineNumber);
    }

    private void rangeCheck(int arg, int max, String name) {
        if (arg < 0 && arg > max) {
            throw new IllegalArgumentException(name + ": " + arg);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber phoneNumber = (PhoneNumber) obj;
        return phoneNumber.lineNumber == this.lineNumber &&
                phoneNumber.prefix == this.prefix &&
                phoneNumber.areaCode == this.areaCode;
    }

    // the worst possible legal hash function - never use
//    @Override
//    public int hashCode() {
//        return 42;
//    }


//    @Override
//    public int hashCode() {
//        int result = 17;
//        result = 31 * result + areaCode;
//        result = 31 * result + lineNumber;
//        result = 31 * result + prefix;
//        return result;
//    }


    /**
     * Lazily initialized, cached hashcode
     * @return
     */
    @Override
    public int hashCode() {
        int result = hashcode;
        if (result == 0) {
            result = 17;
            result = 31 * result + areaCode;
            result = 31 * result + lineNumber;
            result = 31 * result + prefix;
            hashcode =  result;
        }
        return result;
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<>();
        map.put(new PhoneNumber(22, 33, 44), "test");
        System.out.println(map.get(new PhoneNumber(22, 33, 44)));

        System.out.println(Double.doubleToLongBits(2.0));
        System.out.println(Double.parseDouble("2.0"));
        int i = 25;
        int a = 70;
        // 25 * (2^6 + 6)
        // 25 * (2^6 + 2^2 + 2)
        // 25 * 2^6 + 25*2^2 + 25 * 2^1
        // 25 <<< 6 + 25 <<<2 + 25 <<<1
        System.out.println(i * a);
        System.out.println((25<<6) + (25 <<2) + (25 <<1));

    }

    @Override
    public int compareTo(PhoneNumber o) {
//        if (areaCode < o.areaCode)
//            return -1;
//        if (areaCode > o.areaCode)
//            return 1;
//
//        if (prefix < o.prefix)
//            return -1;
//        if (prefix > o.prefix)
//            return 1;
//
//        return Short.compare(lineNumber, o.lineNumber);

        int areaDiff = areaCode - o.areaCode;
        if (areaDiff != 0) {
            return areaDiff;
        }

        int prefixDiff = prefix - o.prefix;
        if (prefixDiff != 0) {
            return prefixDiff;
        }

        return lineNumber - o.lineNumber;

    }
}
