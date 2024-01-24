import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_POSITION = 1000000;
    public static int[] arr = new int[MAX_POSITION + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int maxIdx = 0;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int candy = Integer.parseInt(st.nextToken());;
            int idx = Integer.parseInt(st.nextToken());
            maxIdx = Math.max(maxIdx, idx);
            arr[idx] += candy;
        }

        long maxCandy = 0;
        long curCandy = 0;
        int j = -1;
        for(int i = 0 ; i < N ; i++){
            while(j + 1 <= maxIdx && j + 1 <= i + 2 * K ){
                curCandy += arr[j + 1];
                j++;
            }

            if(maxCandy < curCandy){
                maxCandy = curCandy;
            }

            curCandy -= arr[i];
        }

        bw.write(maxCandy + "");

        br.close();
        bw.close();
    }
}