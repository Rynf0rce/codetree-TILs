import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 200000;
    public static int[] left = new int[MAX_NODE + 1];
    public static int[] right = new int[MAX_NODE + 1];

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

        long K = Long.parseLong(br.readLine());
        int curIdx = 1;
        // 짝, 홀
        while(K > 0){
            if(left[curIdx] == -1 && right[curIdx] == -1){
                curIdx = curIdx;
                System.out.print(curIdx);
                break;
            }
            else if(left[curIdx] == -1){
                curIdx = right[curIdx];
            }
            else if(right[curIdx] == -1){
                curIdx = left[curIdx];
            }
            else if(K % 2 == 1){
                curIdx = left[curIdx];
                K = (K / 2) + 1;
            }
            else{
                curIdx = right[curIdx];
                K /= 2;
            }

            if(K == 0){
                System.out.print(curIdx);
            }
        }
        

    }
}