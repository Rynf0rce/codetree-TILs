import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] arrX = new int[MAX_LENGTH];
    public static int[] arrY = new int[MAX_LENGTH];
    public static final int MAX_INT = (int)1e9;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arrX[i] = Integer.parseInt(st.nextToken());
            arrY[i] = Integer.parseInt(st.nextToken());
        }

        int ans = MAX_INT;
        for(int i = 1 ; i < n - 1 ; i++){
            int curIdx = 0;
            int sum = 0;
            for(int j = 1 ; j < n ; j++){
                if(i == j){
                    continue;
                }
                sum += Math.abs(arrX[curIdx] - arrX[j]) + Math.abs(arrY[curIdx] - arrY[j]);
                curIdx = j;
            }
            ans = Math.min(ans, sum);
        }
        System.out.print(ans);
    }
}