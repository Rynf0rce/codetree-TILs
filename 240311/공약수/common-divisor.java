import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 3;
    public static final int MAX_INT = 100000;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int range = MAX_INT;
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            range = Math.min(range, arr[i]);
        }

        for(int i = 1 ; i <= range ; i++){
            int cnt = 0;
            for(int j = 0 ; j < n ; j++){
                if(arr[j] % i == 0){
                    cnt++;
                }
            }

            if(cnt == n){
                System.out.println(i);
            }
        }
    }
}