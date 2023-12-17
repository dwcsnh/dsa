package Tuan10;

public class IsThisABinarySearchTree {
        /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

    The Node class is defined as follows:
        class Node {
            int data;
            Node left;
            Node right;
        }
    */
    int[] a = new int[1000000 + 5];
    int size = 0;

    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            a[++size] = root.data;
            inOrder(root.right);
        }
    }

    boolean checkBST(Node root) {
        inOrder(root);
        for (int i = 1; i < size; i++) {
            if (a[i] >= a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}