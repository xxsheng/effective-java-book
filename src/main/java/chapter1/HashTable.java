package chapter1;

public class HashTable implements Cloneable{

    private Entry[] buckets;

    @Override
    public HashTable clone() {
        try {
            HashTable clone = (HashTable) super.clone();
            clone.buckets = new Entry[this.buckets.length];
            for (int i = 0; i < this.buckets.length; i++) {
                clone.buckets[i] = this.buckets[i].deepClone();
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * Broken - results in shared internal state
     * @return
     */
//    @Override
//    public HashTable clone() {
//        try {
//            HashTable clone = (HashTable) super.clone();
//            clone.buckets = this.buckets.clone();
//            return clone;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }



    private static class Entry{
        final Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // Recursively copy the linked list headed by this Entry
        public Entry deepClone() {
            return new Entry(this.key, this.value,
                    next == null ? null : next.deepClone());
        }

        // Iteratively copy the linked list headed by this entry
        public Entry deepCloneByIterator() {
            Entry entry = new Entry(key, value, next);
            for (Entry p = entry; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }

            return entry;
        }
    }

}
