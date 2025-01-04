import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 

        long[] arrState = new long[N+1];

        for(int cmdIdx=0; cmdIdx<M; cmdIdx++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            
            if(a == 1) {
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                long mask = 1L << (x - 1);
                arrState[i] |= mask;
                
            } else if(a == 2) {
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                long mask = 1L << (x - 1);
                arrState[i] &= ~mask;
                
            } else if(a == 3) {
                int i = Integer.parseInt(st.nextToken());
                arrState[i] <<= 1;
                arrState[i] &= (1L << 20) - 1;
                
            } else { // a == 4
                int i = Integer.parseInt(st.nextToken());
                arrState[i] >>= 1;
            }
        }

        HashSet<Long> set = new HashSet<>();
        for(int i=1; i<=N; i++){
            set.add(arrState[i]);
        }

        System.out.println(set.size());
    }
}
