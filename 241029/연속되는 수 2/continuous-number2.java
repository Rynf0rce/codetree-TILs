import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 1;
        int cnt = 1;
        for(int i = 1 ; i <= N ; i++){
            if(arr[i] == arr[i - 1]){
                cnt++;
            }
            else{
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
        }
        System.out.print(ans);
    }
}