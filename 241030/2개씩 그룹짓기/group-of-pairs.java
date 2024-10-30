import java.util.*;
import java.io.*;
public class Main {
    public static final int MAX_LENGTH = 1000 * 2;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 2 * N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, 2 * N);

        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            ans = Math.max(ans, arr[2 * N - i - 1] + arr[i]);
        }
        System.out.print(ans);
    }
}