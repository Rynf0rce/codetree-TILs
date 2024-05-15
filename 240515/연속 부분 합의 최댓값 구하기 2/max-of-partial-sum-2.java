import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int MIN_VAL = -1000;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = MIN_VAL;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += arr[i];
            ans = Math.max(ans, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        System.out.print(ans);
    }
}