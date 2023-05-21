package instance;

public class Elvis1 {

    private final static Elvis1 ELVIS_1 = new Elvis1();
    private Elvis1() {
    }

    public static Elvis1 getInstance() {
        return ELVIS_1;
    }


}
