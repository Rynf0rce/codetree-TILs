import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static final int MAX_INT = (int)1e9;
    public static int[] arr = new int[MAX_LENGTH  + 1];
    public static int[] prefix = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Math.abs(Integer.parseInt(st.nextToken()) - H);
        }

        for(int i = 1 ; i <= N ; i++){
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int ans = MAX_INT;
        for(int i = 1 ; i <= N - T + 1 ; i++){
            ans = Math.min(ans, prefix[i + T - 1] - prefix[i - 1]);
        }
        System.out.print(ans);
    }
}