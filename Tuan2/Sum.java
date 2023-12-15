package Tuan2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Sum {
    class Binary {
        public static int search(int[] a, int k, int left, int right) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (a[mid] > k) {
                    right = mid - 1;
                } else if (a[mid] < k) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        try {
            // Scanner name = new Scanner(System.in);
            File myObj = new File("Tuan2\\4Kints.txt");
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
            File secObj = new File("Tuan2\\4Kints.txt");
            Scanner Reader = new Scanner(secObj);

            while(Reader.hasNextLine())
            {
                String line = Reader.nextLine();
                Scanner numReader = new Scanner(line);
                a[id] = numReader.nextInt();
                id++;
                numReader.close();
            }

            Arrays.sort(a);
            int pairCount = 0;
            for (int i = 0; i < a.length; i++) {
                if (Binary.search(a, -a[i], i, a.length - 1) > i) {
                    pairCount++;
                }
            }
            System.out.println(pairCount);
            Reader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
