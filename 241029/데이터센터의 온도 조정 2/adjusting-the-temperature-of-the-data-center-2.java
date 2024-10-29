import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 1000;
    public static int[] arrLeft = new int[MAX_LENGTH + 1];
    public static int[] arrRight = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arrLeft[i] = Integer.parseInt(st.nextToken());
            arrRight[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = -1 ; i <= MAX_LENGTH ; i++){
            int val = 0;
            for(int j = 0 ; j < N ; j++){
                if(i < arrLeft[j]){
                    val += C;
                }
                else if(i > arrRight[j]){
                    val += H;
                }
                else{
                    val += G;
                }
            }
            ans = Math.max(val, ans);
        }
        System.out.print(ans);
    }
}