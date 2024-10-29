import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static final int MAX_HEIGHT = 1000;
    public static int[] arr = new int[MAX_LENGTH + 2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for(int i = 1 ; i <= MAX_HEIGHT ; i++){
            boolean triger = false;
            int cnt = 0;
            for(int j = 0 ; j <= MAX_LENGTH + 1 ; j++){
                if(arr[j] <= i){
                    triger = false;
                }
                else if(arr[j] > i && !triger){
                    cnt++;
                    triger = true;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
        
    }
}