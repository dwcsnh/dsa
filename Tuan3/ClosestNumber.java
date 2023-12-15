package Tuan3;

import java.util.Arrays;
import java.util.Scanner;
public class ClosestNumber {
    public static int[] closestNumber(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int min = arr[1] - arr[0];
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int difference = arr[i + 1] - arr[i];
            if (difference < min) {
                min = difference;
                count = 1;
            }
            else if (difference == min) {
                count++;
            }
        }
        int[] result = new int[count * 2];
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            if(arr[i + 1] - arr[i] == min) {
                result[index] = arr[i];
                result[index + 1] = arr[i + 1];
                index += 2;
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        int size = closestNumber(array).length;
        for (int i = 0; i < size; i++) {
            System.out.print(closestNumber(array)[i] + " ");
        }
        input.close();
    }
}

