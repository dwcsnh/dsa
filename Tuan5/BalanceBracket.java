package Tuan5;

import java.util.Scanner;

public class BalanceBracket {
    static class CharStack {
        char[] stack = new char[10000 + 5];
        int top = -1;

        public void add(char c) {
            stack[++top] = c;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public char poll() {
            if (top >= 0) {
                return stack[top--];
            }
            return 'a';
        }
    }

    public static String balanceCheck (String line) {
        CharStack charStack = new CharStack();
        for (int j = 0; j < line.length(); j++) {
            char c = line.charAt(j);
            if (c == '(' || c == '[' || c == '{') {
                charStack.add(c);
            } else {
                if (charStack.isEmpty()) {
                    return "NO";
                } else if (c == ')' && charStack.poll() != '(') {
                    return "NO";
                } else if (c == ']' && charStack.poll() != '[') {
                    return "NO";
                } else if (c == '}' && charStack.poll() != '{') {
                    return "NO";
                }
            }
        }
        if (charStack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            System.out.println(balanceCheck(line));
        }
        input.close();
    }
}
