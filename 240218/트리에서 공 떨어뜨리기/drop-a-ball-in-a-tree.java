import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 200000;
    public static int[] left = new int[MAX_NODE + 1];
    public static int[] right = new int[MAX_NODE + 1];
    public static int[] ball = new int[MAX_NODE + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            left[i] = l;
            right[i] = r;
        }

        int K = Integer.parseInt(br.readLine());
        while(K-- > 0){
            int curIdx = 1;
            while(true){
                ball[curIdx]++;
                if(left[curIdx] == -1 && right[curIdx] == -1){
                    break;
                }
                else if(left[curIdx] == -1){
                    curIdx = right[curIdx];
                    continue;
                }
                else if(right[curIdx] == -1){
                    curIdx = left[curIdx];
                    continue;
                }
                else if(ball[left[curIdx]] <= ball[right[curIdx]]){
                    curIdx = left[curIdx];
                }
                else{
                    curIdx = right[curIdx];
                }
            }

            if(K == 0){
                System.out.print(curIdx);
            }
        }

    }
}