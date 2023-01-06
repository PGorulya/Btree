package org.parametr;

import java.util.Comparator;

public class Node<T> {

    public T value;
    public Node<T> left;
    public Node<T> right;

    Comparator<T> comparator;

    Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    Node(T value, Comparator<T> comparator) {
//        super();
        this.value = value;
        this.left = null;
        this.right = null;
        this.comparator = comparator;
    }

    private boolean isNodeExist(Node<T> node) {
        return node != null && node.value != null;
    }

    //root
    public void createNode(Node<T> node, T value) {
        node.left = new Node<>(null);
        node.right = new Node<>(null);
        node.value = value;
    }

    public void insert(Node<T> node, T value) {
        if (!isNodeExist(node)) {
            createNode(node, value);
        } else if (comparator.compare(node.value, value) > 0) {
            insert(node.left, value);
        } else {
            insert(node.right, value);
        }
    }

    //++todo
    public Node<T> search(Node<T> node, T value) {
        if (node.value.equals(value)) {
            return node;
        } else if (comparator.compare(node.value, value) > 0 && node.left != null) {
            return search(node.left, value);
        } else if (comparator.compare(node.value, value) < 0 && node.right != null) {
            return search(node.right, value);
        } else return null;
    }

    public Node<T> getMin(Node<T> node) {
        if (!isNodeExist(node)) {
            return null;
        }
        if ((!isNodeExist(node.left))) {
            return node;
        }
        return getMin(node.left);
    }

    //++todo
    public Node<T> getMax(Node<T> node) {
        if (!isNodeExist(node)) {
            return null;
        }
        if ((!isNodeExist(node.right))) {
            return node;
        }
        return getMax(node.right);
    }

    //симметричный обход
    public void inOrderTraversal(Node<T> node) {
        if (!isNodeExist(node)) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print("[ " + node.value + " ] ");
        inOrderTraversal(node.right);
    }

    //++todo
    //обратный обход
    public void postOrderTraversal(Node<T> node) {
        if (!isNodeExist(node)) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print("[ " + node.value + " ] ");
    }

    //++todo
    //прямой обход
    public void directOrderTraversal(Node<T> node) {
        if (!isNodeExist(node)) {
            return;
        }
        System.out.print("[ " + node.value + " ] ");
        directOrderTraversal(node.left);
        directOrderTraversal(node.right);
    }

    //todo class
    public Node<T> remove(Node<T> node, T value) {
        if (!isNodeExist(node)) {
            return null;
        }
        if (comparator.compare(node.value, value) > 0) {
            node.left = remove(node.left, value);
        } else if (comparator.compare(node.value, value) < 0) {
            node.right = remove(node.right, value);

        } else {
            // if nodeToBeDeleted have both children
            if ((node.left.value != null) && (node.right.value != null)) {
                // Finding minimum element from right
                Node<T> minNodeForRight = getMin(node.right);
                // Replacing current node with minimum node from right subtree
                node.value = minNodeForRight.value;
                // Deleting minimum node from right now
                node.right = remove(node.right, minNodeForRight.value);

            }
            // if nodeToBeDeleted has only left child
            else if (node.left.value != null) {
                node = node.left;
            }
            // if nodeToBeDeleted has only right child
            else if (node.right.value != null) {
                node = node.right;
            }
            // if nodeToBeDeleted do not have child (Leaf node)
            else {
                node = null;
            }
        }
        return node;
    }

    //++todo class
    public int getChildrenCount(Node<T> node) {
        if (!isNodeExist(node)) {
            return 0;
        }
        return getChildrenCount(node.left) + getChildrenCount(node.right) + 1;
    }

    public int getHigh(Node<T> node) {
        if (!isNodeExist(node)) {
            return -1;
        }
        int u = getHigh(node.left);
        int v = getHigh(node.right);
        return (u > v) ? u + 1 : v + 1;
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

}

