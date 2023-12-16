package Tuan5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        try {
            // Scanner name = new Scanner(System.in);
            File myObj = new File("Tuan2\\1Mints.txt");
            Scanner fileReader = new Scanner(myObj);
            int cnt = 0;
            while(fileReader.hasNextLine())
            {
                fileReader.nextLine();
                cnt++;
            }

            System.out.println(cnt);
            int []a = new int[cnt];
            int id = 0;
            File secObj = new File("Tuan2\\1Mints.txt");
            Scanner Reader = new Scanner(secObj);

            while(Reader.hasNextLine())
            {
                String line = Reader.nextLine();
                Scanner numReader = new Scanner(line);
                a[id] = numReader.nextInt();
                id++;
                numReader.close();
            }
            long start = System.currentTimeMillis();
            for (int i = 0; i < cnt; i++) {
                int min = a[i];
                int minIndex = i;
                for (int j = i + 1; j < cnt; j++) {
                    if (a[j] < min) {
                        min = a[j];
                        minIndex = j;
                    }
                }
                int temp = a[i];
                a[i] = min;
                a[minIndex] = temp;
            }
            long end = System.currentTimeMillis();
            // for (int i = 0; i < cnt; i++) {
            //     System.out.print(a[i] + " ");
            // }
            System.out.println();
            System.out.println("Time cost for sorting " + cnt + " integers: " + (end - start) + " miliseconds");
            Reader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
