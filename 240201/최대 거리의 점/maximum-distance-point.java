import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 200000;
    public static final int MAX_INT = 1000000000;
    public static int[] arr = new int[MAX_LENGTH];
    public static int n, m;

    public static boolean isPossible(int length){
        int idx = 0;
        int cnt = 1;
        for(int i = 1 ; i < n ; i++){
            // System.out.println(arr[i] + " - " + arr[idx] + " >= " + length);
            if(arr[i] - arr[idx] >= length){
                idx = i;
                cnt++;
            }
            
            if(cnt >= m){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 0, n);

        int start = 0;
        int end = MAX_INT;
        int ans = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            // System.out.println(start + " " + end);
            if(isPossible(mid)){
                start = mid + 1;
                ans = Math.max(ans, mid);
            }
            else{
                end = mid - 1;
            }
        }

        bw.write(ans + "");

        br.close();
        bw.close();
    }
}