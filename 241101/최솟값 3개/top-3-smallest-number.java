import java.util.*;
import java.io.*;

public class Main {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(st.nextToken());
            if(i < 3){
                if(i == 0){
                    ans = num;
                }
                else{
                    ans *= num;
                }
                pq.add(num);
                if(i == 2){
                    System.out.println(ans);
                }
                else{
                    System.out.println(-1);
                }
                continue;
            }

            if(pq.peek() > num){
                ans /= pq.poll();
                ans *= num;
                pq.add(num);
            }
            System.out.println(ans);
        }
    }
}