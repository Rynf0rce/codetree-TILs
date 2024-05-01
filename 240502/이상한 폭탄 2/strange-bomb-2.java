import java.util.*;
import java.io.*;

public class Main {
    public static int MAX_NUM = 1000;
    public static int[] dist = new int[MAX_NUM + 1];
    public static boolean[] bombed = new boolean[MAX_NUM + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int ans = -1;

        for(int i = 0 ; i < N ; i++){
            dist[i] = -1;
        }

        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            if(dist[num] == -1){
                dist[num] = i;
            }
            else{
                if( i - dist[num] <= K && !bombed[num]){
                    bombed[num] = true;
                    ans = Math.max(ans, num);
                }
                else{
                    dist[num] = i;
                }
            }
        }
        System.out.print(ans);
    }
}