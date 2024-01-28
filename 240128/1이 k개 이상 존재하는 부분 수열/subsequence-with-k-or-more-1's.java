import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 1000000;
    public static int[] arr = new int[MAX_LENGTH];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int j = -1;
        int cnt = 0;
        int minVal = MAX_LENGTH + 1;
        for(int i = 0 ; i < n ; i++){
            while(j + 1 < n && cnt < k ){
                if(arr[j + 1] == 1){
                    cnt++;
                }
                j++;
            }

            if(j == n - 1 && cnt < k){
                break;
            }

            // System.out.println(j + " " + i);
            minVal = Math.min(minVal, j - i + 1);

            if(arr[i] == 1){
                cnt--;
            }
        }

        bw.write(minVal + "");

        br.close();
        bw.close();
    }
}