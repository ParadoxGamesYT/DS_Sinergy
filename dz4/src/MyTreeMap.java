class MyTreeMap<K extends Comparable<K>, V> {
    private MyBinarySearchTree<Entry<K, V>> binarySearchTree;

    public MyTreeMap() {
        binarySearchTree = new MyBinarySearchTree<>();
    }

    public V put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);
        MyBinarySearchTree<Entry<K, V>>.Node node = binarySearchTree.add(entry);
        if (node == null) {
            return null;
        } else {
            Entry<K, V> oldEntry = node.getValue();
            node.setValue(entry);
            return oldEntry.getValue();
        }
    }

    public V remove(K key) {
        Entry<K, V> entry = new Entry<>(key, null);
        MyBinarySearchTree<Entry<K, V>>.Node node = binarySearchTree.remove(entry);
        if (node == null) {
            return null;
        } else {
            return node.getValue().getValue();
        }
    }

    public boolean containsKey(K key) {
        Entry<K, V> entry = new Entry<>(key, null);
        return binarySearchTree.contains(entry);
    }

    public void clear() {
        binarySearchTree.clear();
    }

    public int size() {
        return binarySearchTree.size();
    }

    public boolean isEmpty() {
        return binarySearchTree.isEmpty();
    }

    public MyBinarySearchTree<Entry<K, V>> getTree() {
        return binarySearchTree;
    }
    static class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public int compareTo(Entry<K, V> other) {
            return key.compareTo(other.getKey());
        }
    }
}