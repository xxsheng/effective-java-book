package chapter1;

public class Finalizer {

    /**
     * FileInputStream FileOutputStream  Timer Connection 都重写了finalizer方法
     *
     */


    public static void main(String[] args) {
//        System.runFinalization();
//        System.runFinalizersOnExit(true);
        Finalizer finalizer = new Finalizer();
        finalizer.test1();
        finalizer = null;
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("exe finalize");
        } catch (Exception e) {
            super.finalize();
        }
    }

    private void test1() {
        System.out.println("test1");
    }
}
