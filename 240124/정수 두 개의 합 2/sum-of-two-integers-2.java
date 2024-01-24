import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arr = new int[MAX_LENGTH];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 0, n);

        int j = n - 1;
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            while(i < j && arr[i] + arr[j] > k){
                j--;
            }

            if(i >= j){
                break;
            }

            cnt += j - i;
        }

        bw.write(cnt + "");

        br.close();
        bw.close();
    }
}