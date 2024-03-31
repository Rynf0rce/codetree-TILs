import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static final int MAX_INT = (int)1e9;
    public static int[] arr = new int[MAX_LENGTH];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int sum = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int ans = MAX_INT;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(i == j){
                    continue;
                }

                ans = Math.min(ans, Math.abs(S - (sum - arr[i] - arr[j])));
            }
        }
        
        System.out.print(ans);
    }
}