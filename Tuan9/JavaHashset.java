package Tuan9;

import java.util.*;

public class JavaHashset {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String [] left = new String[n];
        String [] right = new String[n];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            left[i] = input.next();
            right[i] = input.next();
            set.add(left[i] + "  " + right[i]);
            System.out.println(set.size());
        }
        input.close();
    }
}