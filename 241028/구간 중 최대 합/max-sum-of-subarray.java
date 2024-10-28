import java.util.*;
import java.io.*;

public class Main {
    public static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int sum = 0;
        int ans = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            q.add(num);
            
            if(q.size() == k){
                ans = Math.max(ans, sum);
                sum -= q.poll();
            }
        }
        System.out.print(ans);
    }
}