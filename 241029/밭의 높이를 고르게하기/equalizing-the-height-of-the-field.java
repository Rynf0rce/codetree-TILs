import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static final int INVALID = (int)1e9;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < N ; i++){
            arr[i] = Math.abs(Integer.parseInt(st.nextToken()) - H);
        }

        int ans = INVALID;
        int j = 0;
        int val = 0;
        for(int i = 0 ; i < N - T + 1 ; i++){
            // System.out.println(i + " " + j);
            val += arr[i];
            if(i - j + 1 > T){
                // System.out.println("s");
                val -= arr[j++];
            }
            
            // System.out.println(val);
            if(i - j + 1 == T){
                // System.out.println("c");
                ans = Math.min(ans, val);
            }
        }
        System.out.print(ans);
    }
}