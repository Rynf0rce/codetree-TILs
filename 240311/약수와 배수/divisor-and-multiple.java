import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        int divisorSum = 0;
        int multipleSum = 0;
        for(int i = 0 ; i < n ; i++){
            if(k % arr[i] == 0){
                divisorSum += arr[i];
            }
            
            if(arr[i] % k == 0){
                multipleSum += arr[i];
            }
        }
        System.out.print(divisorSum + "\n" + multipleSum);
    }
}