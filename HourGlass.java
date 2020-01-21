import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        ArrayList<Integer> sums = new ArrayList<>();
        for(int x=0;x<4;x++){//going down rows
            //now summing within each row
            for(int a=0;a<4;a++){
                int top = arr[x][a]+arr[x][a+1]+arr[x][a+2];
                int mid = arr[x+1][a+1];
                int bot = arr[x+2][a]+arr[x+2][a+1]+arr[x+2][a+2];
                sums.add(top+mid+bot);
            }
        }
        int max = sums.get(0);
        for (int x=0;x<sums.size();x++){
            if(sums.get(x)>max){
                max = sums.get(x);
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
