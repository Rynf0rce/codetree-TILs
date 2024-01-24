import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arr = new int[MAX_LENGTH];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int j = -1;
        int sum = 0;
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            while(j + 1 < n && sum < m){
                sum += arr[j + 1];
                j++;
            }

            if(j >= n && sum < m){
                break;
            }
            
            if(sum == m){
                cnt++;
            }
            sum -= arr[i];
        }

        bw.write(cnt + "");
        
        br.close();
        bw.close();
    }
}