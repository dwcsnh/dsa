package Tuan5;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static class CharStack {
        Stack<Character> stack = new Stack<>();
        Stack<Stack<Character>> previousStacks = new Stack<>();
        
        public void add(char c) {
            stack.push(c);
        }
    
        public boolean isEmpty() {
            return stack.isEmpty();
        }
    
        public char poll() {
            return stack.pop();
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
            if (k <= stack.size()) {
                Stack<Character> temp = new Stack<>();
                int count = stack.size() - k;
                
                while (count > 0) {
                    temp.push(stack.pop());
                    count--;
                }
    
                char result = stack.peek();
                
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
                
                System.out.println(result);
            }
        }
    
        public void undo() {
            if (!previousStacks.isEmpty()) {
                stack = previousStacks.pop();
            }
        }
    
        public void saveState() {
            Stack<Character> newState = new Stack<>();
            newState.addAll(stack);
            previousStacks.push(newState);
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
