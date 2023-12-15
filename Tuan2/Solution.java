package Tuan2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            File myObj = new File("Tuan2\\tinyUF.txt");
            Scanner fileReader = new Scanner(myObj);
            int N = fileReader.nextInt();
            int unionCount = 0;
            UFClient ufClient = new UFClient(N);
            while(fileReader.hasNextLine() && !ufClient.isConnected()) 
            {
                String line = fileReader.nextLine();
                Scanner numReader = new Scanner(line);
                if (numReader.hasNextInt() && numReader.hasNextInt()) 
                {
                    int p = numReader.nextInt();
                    int q = numReader.nextInt();
                    if (!ufClient.connected(p, q)) 
                    {
                        ufClient.union(p, q);
                    }
                    unionCount++;
                }
                numReader.close();
            }
            fileReader.close();
            ufClient.printUnion();
            System.out.print("\n");
            System.out.println("Number of groups: " + ufClient.numberOfComponents());
            if (ufClient.isConnected())
            {
                System.out.println("Number of unions: " + unionCount);
            }
            else
            {
                System.out.println("FAILED!");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //1818305188
        //0 8 1 8 3 8 5 0 0 8

    }
}