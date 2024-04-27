import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_CASE = 100;
    public static final int MAX_LENGTH = 1000;
    public static boolean[] operated = new boolean[MAX_LENGTH + 1];
    public static int[] start = new int[MAX_CASE];
    public static int[] end = new int[MAX_CASE];
    public static int n = -1;

    public static int calTime(int exceptNum){
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(exceptNum == i){
                continue;
            }

            for(int j = start[i] ; j < end[i] ; j++){
                operated[j] = true;
            }
        }

        for(int j = 1 ; j <= MAX_LENGTH ; j++){
            if(operated[j]){
                ans++;
            }
            operated[j] = false;
        }
        
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans, calTime(i));
        }
        System.out.print(ans);
    }
}