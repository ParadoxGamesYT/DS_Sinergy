class MyBinarySearchTree<T extends Comparable<T>> {
    private Node root;
    private int size;

    public MyBinarySearchTree() {
        root = null;
        size = 0;
    }

    public Node add(T value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            size++;
            return root;
        } else {
            return addRecursively(root, newNode);
        }
    }

    private Node addRecursively(Node currentNode, Node newNode) {
        if (newNode.getValue().compareTo(currentNode.getValue()) < 0) {
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);
                size++;
                return newNode;
            } else {
                return addRecursively(currentNode.getLeft(), newNode);
            }
        } else if (newNode.
                getValue().compareTo(currentNode.getValue()) > 0) {
            if (currentNode.getRight() == null) {
                currentNode.setRight(newNode);
                size++;
                return newNode;
            } else {
                return addRecursively(currentNode.getRight(), newNode);
            }
        } else {
            return null;
        }
    }

    public Node remove(T value) {
        Node nodeToRemove = findNode(value);
        if (nodeToRemove == null) {
            return null;
        } else {
            Node parent = findParent(nodeToRemove);
            Node replacement = findReplacement(nodeToRemove);
            if (replacement != null) {
                replacement.setLeft(nodeToRemove.getLeft());
                replacement.setRight(nodeToRemove.getRight());
            }
            if (parent == null) {
                root = replacement;
            } else if (parent.getLeft() == nodeToRemove) {
                parent.setLeft(replacement);
            } else {
                parent.setRight(replacement);
            }
            size--;
            return nodeToRemove;
        }
    }

    private Node findNode(T value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (value.compareTo(currentNode.getValue()) < 0) {
                currentNode = currentNode.getLeft();
            } else if (value.compareTo(currentNode.getValue()) > 0) {
                currentNode = currentNode.getRight();
            } else {
                return currentNode;
            }
        }
        return null;
    }

    private Node findParent(Node node) {
        if (node == root) {
            return null;
        } else {
            Node parent = root;
            while (parent != null) {
                if (parent.getLeft() == node || parent.getRight() == node) {
                    return parent;
                } else if (node.getValue().compareTo(parent.getValue()) < 0) {
                    parent = parent.getLeft();
                } else {
                    parent = parent.getRight();
                }
            }
            return null;
        }
    }

    private Node findReplacement(Node node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return null;
        } else if (node.getLeft() != null && node.getRight() == null) {
            return node.getLeft();
        } else if (node.getLeft() == null && node.getRight() != null) {
            return node.getRight();
        } else {
            Node replacement = node.getRight();
            while (replacement.getLeft() != null) {
                replacement = replacement.getLeft();
            }
            Node parent = findParent(replacement);
            if (parent != node) {
                parent.setLeft(replacement.getRight());
                replacement.setRight(node.getRight());
            }
            replacement.setLeft(node.getLeft());
            return replacement;
        }
    }

    public boolean contains(T value) {
        return findNode(value) != null;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node getRoot() {
        return root;
    }

    public void traverseInOrder() {
    }

    class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }

        public T getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setValue(T entry) {
        }
    }
}