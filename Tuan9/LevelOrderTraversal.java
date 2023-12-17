package Tuan9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {  
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

    
    static void levelOrderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
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
        levelOrderTraversal(head);
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