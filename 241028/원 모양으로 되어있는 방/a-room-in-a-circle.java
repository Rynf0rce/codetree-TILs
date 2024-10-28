import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 1003;
    public static final int INVALID = (int)1e9;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static int N = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int ans = INVALID;
        for(int i = 1 ; i <= N ; i++){
            int val = 0;
            int idx = i;
            int gap = 0;
            for(int j = 0 ; j < N ; j++){
                if(idx > N){
                    idx = 1;
                }
                val += arr[idx] * gap;
                gap++;
                idx++;
            }
            ans = Math.min(ans, val);
        }
        System.out.print(ans);
    }
}