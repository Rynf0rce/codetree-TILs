import java.util.*;
import java.io.*;

public class Main {
    public static int[] ans = new int[]{100000, 0};

    public static void findAnswer(long m, long target){
        long start = 1;
        long end = m;
        int cnt = 0;
        while(end >= start){
            long mid = (end + start) / 2;
            cnt++;

            if(mid == target){
                ans[0] = Math.min(ans[0], cnt);
                ans[1] = Math.max(ans[1], cnt);
            }

            if(mid > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long m = Long.parseLong(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        for(long i = a ; i <= b ; i++){
            findAnswer(m, i);
        }

        bw.write(ans[0] + " " + ans[1]);

        br.close();
        bw.close();
    }
}