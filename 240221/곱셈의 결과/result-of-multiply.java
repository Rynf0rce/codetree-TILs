import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 1;
        for(int i = 0 ; i < 3 ; i++){
            ans *= Integer.parseInt(br.readLine());
        }

        char[] arr = Integer.toString(ans).toCharArray();
        int[] ansArr = new int[10];
        for(int i = 0 ; i < arr.length ; i++){
            ansArr[arr[i] - '0']++;
        }

        for(int i = 0 ; i < ansArr.length ; i++){
            System.out.println(ansArr[i]);
        }
    }
}