import java.util.*;
import java.io.*;

public class Main {
    public static final int MAL_LENGTH = 10000;
    public static int[] arr = new int[MAL_LENGTH + 1];
    public static int[] prefix = new int[2 * MAL_LENGTH + 1];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            pq.add(idx);
            char c = String.valueOf(st.nextToken()).charAt(0);
            if(c == 'G'){
                arr[idx] = 1;
            }
            else{
                arr[idx] = 2;
            }
        }

        for(int i = 1 ; i < MAL_LENGTH ; i++){
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int ans = 0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            ans = Math.max(ans, prefix[num + K] - prefix[num - 1]);
        }
        System.out.print(ans);
    }
}