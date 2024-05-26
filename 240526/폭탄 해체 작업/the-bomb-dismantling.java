import java.util.*;
import java.io.*;
public class Main {
    public static int MAX_LENGTH = 10000;
    public static int[] arr = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int point = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            arr[time] = Math.max(arr[time], point);
        }

        int ans = 0;
        for(int i = 1 ; i <= MAX_LENGTH ; i++){
            ans += arr[i];
        }
        System.out.print(ans);
    }
}