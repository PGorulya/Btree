package org.simple;

public class Node {

    public Integer value;
    public Node left;
    public Node right;

    Node(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    private static boolean isNodeExist(Node node) {
        return node != null && node.value != null;
    }

    //root
    private static void createNode(Node node, Integer value) {
        node.left = new Node(null);
        node.right = new Node(null);
        node.value = value;
    }

    private static void insert(Node node, Integer value) {
        if (!isNodeExist(node)) {
            createNode(node, value);
        } else if (node.value.compareTo(value) > 0) {
            insert(node.left, value);
        } else {
            insert(node.right, value);
        }
    }

    //++todo
    private static Node search(Node node, Integer value) {
        if (node.value.equals(value)) {
            return node;
        } else if (node.value.compareTo(value) > 0 && node.left != null) {
            return search(node.left, value);
        } else if (node.value.compareTo(value) < 0 && node.right != null) {
            return search(node.right, value);
        } else return null;
    }

    private static Node getMin(Node node) {
        if (!isNodeExist(node)) {
            return null;
        }
        if ((!isNodeExist(node.left))) {
            return node;
        } else return getMin(node.left);
    }

    //++todo
    private static Node getMax(Node node) {
        if (!isNodeExist(node)) {
            return null;
        }
        if ((!isNodeExist(node.right))) {
            return node;
        }
        return getMax(node.right);
    }

    //симметричный обход
    private static void inOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print("[ " + node.value + " ] ");
        inOrderTraversal(node.right);
    }

    //++todo
    //обратный обход
    private static void postOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print("[ " + node.value + " ] ");
    }

    //++todo
    //прямой обход
    private static void directOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        System.out.print("[ " + node.value + " ] ");
        directOrderTraversal(node.left);
        directOrderTraversal(node.right);
    }

    //todo class
    private static Node remove(Node node, Integer value) {
        if (!isNodeExist(node)) {
            return null;
        }
        if (node.value.compareTo(value) > 0) {
            node.left = remove(node.left, value);
        } else if (node.value.compareTo(value) < 0) {
            node.right = remove(node.right, value);

        } else {
            // if nodeToBeDeleted have both children
            if ((node.left.value != null) && (node.right.value != null)) {
                // Finding minimum element from right
                Node minNodeForRight = getMin(node.right);
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
    private static int getChildrenCount(Node node) {
        if (!isNodeExist(node)) {
            return 0;
        }
        return getChildrenCount(node.left) + getChildrenCount(node.right) + 1;
    }

    private static int getHigh(Node node) {
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

    public static void main(String[] args) {
        Integer[] digit = {9, 2, 5, 13, 6, 10, 14, 7, 33, 44, 3};
        Node node = new Node(null);

        for (int i = 0; i < digit.length; i++) {
            insert(node, digit[i]);
        }
        inOrderTraversal(node);
        System.out.println();
        System.out.println("Count of Children = " + getChildrenCount(node));
        System.out.println("High: " + getHigh((node)));
        System.out.println("Min node: " + getMin(node));
        System.out.println("Max node: " + getMax(node));
        System.out.println("Search element: " + search(node, 13));

        Integer n = 13;
        System.out.println("Remove element = " + n);
        remove(node, n);
        inOrderTraversal(node);
    }
}


