package Tuan10;

import java.util.Scanner;

public class BSTInsertion {
    static void insert(Node node, int value) {
        if (value < node.data) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                Node temp = new Node(value);
                node.left = temp;
            }
        } else {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                Node temp = new Node(value);
                node.right = temp;
            }
        }
    }

    static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        Node head = new Node(x);
        for (int i = 1; i < n; i++) {
            x = input.nextInt();
            insert(head, x);
        }
        preOrder(head);
        input.close();
    }
}

class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}