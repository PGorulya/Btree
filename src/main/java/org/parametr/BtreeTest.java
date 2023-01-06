package org.parametr;

import java.util.Comparator;

public class BtreeTest {
    public static void main(String[] args) {
        System.out.println("TEST FOR INTEGER++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Integer[] digit = {9, 2, 5, 13, 6, 10, 14, 7, 33, 44, 3};
        Node<Integer> node = new Node<>(null, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < digit.length; i++) {
            node.insert(node, digit[i]);
        }
        node.inOrderTraversal(node);
        System.out.println();
        System.out.println("Count of Children = " + node.getChildrenCount(node));
        System.out.println("High: " + node.getHigh((node)));
        System.out.println("Min node: " + node.getMin(node));
        System.out.println("Max node: " + node.getMax(node));
        System.out.println("Search element: " + node.search(node, 13));

        Integer n = 13;
        System.out.println("Remove element = " + n);
        node.remove(node, n);
        node.inOrderTraversal(node);

        System.out.println();
        System.out.println("=====================================================================");
        System.out.println("TEST FOR STRING++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        String[] str = {"9", "2", "5", "13", "6", "10", "14", "7", "33", "44", "3"};
        Node<String> nodes = new Node<>(null, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < str.length; i++) {
            nodes.insert(nodes, str[i]);
        }
        nodes.inOrderTraversal(nodes);
        System.out.println();
        System.out.println("Count of Children = " + nodes.getChildrenCount(nodes));
        System.out.println("High: " + nodes.getHigh((nodes)));
        System.out.println("Min node: " + nodes.getMin(nodes));
        System.out.println("Max node: " + nodes.getMax(nodes));
        System.out.println("Search element: " + nodes.search(nodes, "13"));

    }
}
