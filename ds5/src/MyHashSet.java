public class MyHashSet<E> {
    private static final Object PRESENT = new Object();
    private transient MyHashMap<E,Object> hashMap;
    public MyHashSet() {
        hashMap = new MyHashMap<>();
    }
    public boolean contains(Object o) {
        return hashMap.containsKey(o);
    }
    public int size() {
        return hashMap.getSize();
    }
    public boolean add(E e) {
        hashMap.put(e, PRESENT);
        return true;
    }
    public boolean remove(Object o) {
        hashMap.delete(o);
        return true;
    }
}