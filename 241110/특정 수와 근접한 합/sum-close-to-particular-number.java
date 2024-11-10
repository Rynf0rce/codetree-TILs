import java.util.*;
import java.io.*;

public class Main {
    public static final int INVALIED = (int) 1e9;
    public static final int MAX_LENGTH = 100;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int ans = INVALIED;
        for(int i = 0 ; i < N ; i++){
            for(int j = i + 1 ; j < N ; j++){
                ans = Math.min(ans, Math.abs(S - Math.abs(sum - arr[i] - arr[j])));
            }
        }
        System.out.print(ans);
    }
}