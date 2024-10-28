import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = i ; j < N ; j++){
                int sum = 0;
                for(int k = i ; k <= j ; k++){
                    sum += arr[k];
                }

                for(int k = i ; k <= j ; k++){
                    if(sum / (j - i + 1) == arr[j]){
                        ans++;
                    }
                }
                
            }
        }
        System.out.print(ans);
    }
}