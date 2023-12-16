package Tuan4;

public class PrintElements {
    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    class NodeList {
        Node head;

        public void addFirst(int data) {
            Node node = new Node(data, head);
            head = node;
        }

        public void append(int data) {
            if (head == null) {
                head = new Node(data, null);
            } else {
                Node node = head;
                while (node.next != null) {
                    node = node.next;
                }
                node.next = new Node(data, null);
            }
        }

        public void remove() {
            
        }
    }
}
