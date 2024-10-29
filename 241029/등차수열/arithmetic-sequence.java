import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH];
    public static int[] archeive = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1; j < n ; j++){
                int val = arr[i] + arr[j];
                if(val % 2 == 1){
                    continue;
                }
                archeive[val / 2]++;
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= MAX_LENGTH ; i++){
            ans = Math.max(ans, archeive[i]);
        }
        System.out.print(ans);
    }
}