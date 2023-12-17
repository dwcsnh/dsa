package Tuan10;

import java.util.Scanner;

public class LowestCommonAncestor {
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

    public static Node lca(Node root, int v1, int v2) {
        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        } else if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        } else {
            return root;
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
        int v1 = input.nextInt();
        int v2 = input.nextInt();
        System.out.println(lca(head, v1, v2).data);
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