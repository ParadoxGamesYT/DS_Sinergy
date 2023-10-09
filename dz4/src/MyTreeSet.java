public class MyTreeSet<T extends Comparable<T>> {
    private MyTreeMap<T, Object> treeMap;

    public MyTreeSet() {
        treeMap = new MyTreeMap<>();
    }

    public boolean add(T value) {
        return treeMap.put(value, null) == null;
    }

    public boolean remove(T value) {
        return treeMap.remove(value) != null;
    }

    public boolean contains(T value) {
        return treeMap.containsKey(value);
    }

    public void clear() {
        treeMap.clear();
    }

    public int size() {
        return treeMap.size();
    }

    public boolean isEmpty() {
        return treeMap.isEmpty();
    }

    public void traverse() {
        MyBinarySearchTree<T>.Node root = ((MyBinarySearchTree<T>) treeMap.getTree()).getRoot();
        if (root != null) {
            traverseInOrder(root);
        }
    }

    private void traverseInOrder(MyBinarySearchTree<T>.Node node) {
        if (node.getLeft() != null) {
            traverseInOrder(node.getLeft());
        }
        System.out.println(node.getValue());
        if (node.getRight() != null) {
            traverseInOrder(node.getRight());
        }
    }
    public static void main(String[] args) {
        MyTreeSet<Integer> treeSet = new MyTreeSet<>();
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(7);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(6);
        treeSet.add(8);
        treeSet.remove(2);
        System.out.println(treeSet.contains(5)); // Выведет: true
        System.out.println(treeSet.contains(2)); // Выведет: false
        System.out.println(treeSet.size()); // Выведет: 6
        System.out.println(treeSet.isEmpty()); // Выведет: false
    }
}
