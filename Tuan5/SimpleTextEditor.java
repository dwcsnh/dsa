package Tuan5;

import java.util.Scanner;

public class SimpleTextEditor {
    static class CharStack {
        char[] stack = new char[100000 + 5];
        char[][] previousStack = new char[1000][100000 + 5];
        int[] previousSize = new int[1000];
        int step = 0;
        int top = -1;

        public void add(char c) {
            stack[++top] = c;
        }

        public boolean isEmpty() {
            return top < 0;
        }

        public char poll() {
            if (top >= 0) {
                return stack[top--];
            }
            return 'a';
        }

        public void add(String s) {
            saveState();
            for (int i = 0; i < s.length(); i++) {
                add(s.charAt(i));
            }
        }

        public void delete(int k) {
            saveState();
            for (int i = 0; i < k; i++) {
                if (!isEmpty()) {
                    poll();
                }
            }
        }

        public void print(int k) {
            if (k - 1 <= top) {
                System.out.println(stack[k - 1]);
            } 
        }

        public void undo() {
            if (step > 0) {
                step--;
                System.arraycopy(previousStack[step], 0, stack, 0, stack.length);
                top = previousSize[step];
            }
        }
        
        public void saveState() {
            System.arraycopy(stack, 0, previousStack[step], 0, stack.length);
            previousSize[step] = top;
            step++;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int q, k;
        String s;
        String line;
        CharStack charStack = new CharStack();
        input.nextLine();
        for (int i = 0; i < n; i++) {
            line = input.nextLine();
            String[] components = line.split(" ");
            q = Integer.parseInt(components[0]);
            if (q == 1) {
                s = components[1];
                charStack.add(s);
            } else if (q == 2) {
                k = Integer.parseInt(components[1]);
                charStack.delete(k);
            } else if (q == 3) {
                k = Integer.parseInt(components[1]);
                charStack.print(k);
            } else if (q == 4) {
                charStack.undo();
            }
        }
        input.close();
    }
}
