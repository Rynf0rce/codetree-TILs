import java.util.*;
import java.io.*;

public class Main {
    public static int MAX_LENGTH = 100000;
    public static int MAX_TIME = 1000000000;
    public static int[] gate = new int[MAX_LENGTH];

    public static boolean isPossible(int productNum, int gateNum, int time){
        int cnt = 0;
        for(int i = 0 ; i < gateNum ; i++){
            cnt += time / gate[i];
        }
        return cnt >= productNum;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < m ; i++){
            gate[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = MAX_TIME;
        int ans = MAX_TIME + 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(isPossible(n, m, mid)){
                end = mid - 1;
                ans = Math.min(ans, mid);
            }
            else{
                start = mid + 1;
            }
        }

        System.out.print(ans);
    }
}