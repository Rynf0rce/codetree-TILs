import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_PEOPLE = 100;
    public static int[] arr = new int[MAX_PEOPLE];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = -1;
        for(int i = 0 ; i < M ; i++){
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
            if(arr[num] >= K){
                ans = num;
                break;
            }
        }
        System.out.print(ans);
    }
}