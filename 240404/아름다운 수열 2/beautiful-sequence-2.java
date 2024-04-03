import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGATH = 100;
    public static int[] arr = new int[MAX_LENGATH + 1];
    public static int[] target = new int[MAX_LENGATH + 1];
    public static int[] visitedArr = new int[MAX_LENGATH + 1];
    public static int[] targetVisitedArr = new int[MAX_LENGATH + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= M ; i++){
            target[i] = Integer.parseInt(st.nextToken());
            targetVisitedArr[target[i]]++;
        }

        int ans = 0;
        int j = 1;
        for(int i = 0 ; i < N ; i++){
            while(j - i <= M){
                visitedArr[arr[j++]]++;
            }

            boolean flag = true;
            for(int k = 1 ; k <= M ; k++){
                if(visitedArr[target[k]] != targetVisitedArr[target[k]]){
                    flag = false;
                    break;
                }
            }

            if(flag){
                ans++;
            }

            if(j > N){
                break;
            }

            visitedArr[arr[i + 1]]--;
        }
    
        System.out.print(ans);
    }
}