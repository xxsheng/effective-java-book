package chapter1;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceTest extends WeakReference<String> {
    final static ReferenceQueue<String> queue = new ReferenceQueue<>();
    public WeakReferenceTest(String referent) {
        super(referent, queue);
    }


}
