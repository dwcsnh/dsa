package Tuan9;

import java.util.*;

public class JavaMap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Map<String, Integer> contacts = new TreeMap<String, Integer>();

        input.nextLine();
        for (int i = 0; i < n; i++) {
            String name = input.nextLine();
            int phoneNumber = input.nextInt();
            input.nextLine();
            contacts.put(name, phoneNumber);
        }

        while (input.hasNext()) {
            String result = input.nextLine();
            if (contacts.get(result) != null) {
                System.out.println(result + "=" + contacts.get(result));
            } else
                System.out.println("Not found");
        }
        
        input.close();
    }
}

