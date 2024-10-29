import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_WORK = 100;
    public static final int MAX_TIME = 1000;
    public static int[] arrA = new int[MAX_WORK];
    public static int[] arrB = new int[MAX_WORK];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arrA[i] = Integer.parseInt(st.nextToken());
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            boolean[] visited = new boolean[MAX_TIME + 1];
            int cnt = 0;
            for(int j = 0 ; j < N ; j++){
                if(i == j){
                    continue;
                }
                for(int k = arrA[j] ; k < arrB[j] ; k++){
                    if(!visited[k]){
                        cnt++;
                        visited[k] = true;
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}