import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 10000;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int avg = sum / N;
        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            if(arr[i] > avg){
                ans += arr[i] - avg;
            }
        }
        System.out.print(ans);
    }
}