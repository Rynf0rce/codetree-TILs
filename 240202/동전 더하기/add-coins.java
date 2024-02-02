import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 5;
    public static int[] arr = new int[MAX_LENGTH];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            ans += k / arr[i];
            k = k % arr[i];
        }

        bw.write(ans + "");

        br.close();
        bw.close();
    }
}