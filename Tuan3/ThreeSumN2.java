package Tuan3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumN2 {
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

    public static int findSetN2(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length - 2; i++) {
            int j = i + 1;
            for (int k = a.length - 1; k > i + 1; k--) {
                while(j < k) {
                    int sum = a[i] + a[j] + a[k];
                    if (sum == 0) {
                        count++;
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                        break;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println("Number of sets: " + count);
        return count;
    }

    public static void main(String[] args) {
        try {
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
            findSetN2(a);
            Reader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
