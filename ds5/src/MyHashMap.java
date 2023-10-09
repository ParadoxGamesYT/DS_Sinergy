public class MyHashMap<K, V> {
    private int CAPACITY = 10;
    private int size = 0;
    private MyMapBucket[] bucket;
    public int getHash(Object key) {
        return (key.hashCode() & 0xfffffff) % CAPACITY;
    }
    private MyKeyValueEntry getEntry(Object key) {
        int hash = getHash(key);
        for (int i = 0; i < bucket[hash].getEntries().size(); i++) {
            MyKeyValueEntry myKeyValueEntry = bucket[hash].getEntries().get(i);
            if (myKeyValueEntry.getKey().equals(key)) return myKeyValueEntry;
        }
        return null;
    }
    public void put(K key, V value) {
        if (containsKey(key)) {
            MyKeyValueEntry myKeyValueEntry = getEntry(key);
            myKeyValueEntry.setValue(value);
        } else {
            int hash = getHash(key);
            if (bucket[hash] == null) {
                bucket[hash] = new MyMapBucket();
            }
            bucket[hash].addEntry(new MyKeyValueEntry<>(key, value));
            size++;
        }
    }
    public boolean containsKey(Object key) {
        int hash = getHash(key);
        if (bucket[hash] == null) return false;
        if (getEntry(key) != null) return false;
        return true;
    }
    public V get(K key) {
        return containsKey(key) ? (V) getEntry(key).getValue() : null;
    }
    public void delete(Object key) {
        if (containsKey(key)) {
            int hash = getHash(key);
            bucket[hash].removeEntry(getEntry(key));
            size--;
        }
    }
    public int getSize() {
        return size;
    }
    public void printHashMap() {
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != null) {
                System.out.println("bucket number = " + i);
                for (int j = 0; j < bucket[i].getEntries().size(); j++) {
                    System.out.println(bucket[i].getEntries().get(i).getValue());
                }
                System.out.println("________");
            }
        }
    }
}
