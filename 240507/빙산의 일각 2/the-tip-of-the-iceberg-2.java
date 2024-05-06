import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 1000;
        int end = 0;
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            start = Math.min(start, arr[i]);
            end = Math.max(end, arr[i]);
        }

        int ans = 0;
        for(int k = start ; k <= end ; k++){
            boolean flag = false;
            int cnt = 0;
            for(int i = 0 ; i < n ; i++){
                if(arr[i] >= k){
                    if(!flag){
                        cnt++;
                    }
                    flag = true;
                }
                else{
                    flag = false;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}