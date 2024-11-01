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
            if(i == 0){
                ans = num;
            }
            else if(i < 3){
                ans *= num;
            }

            pq.add(num);
            if(pq.size() < 3){
                System.out.println(-1);
            }
            else if(pq.size() == 3){
                System.out.println(ans);
            }
            else{
                if(pq.peek() > num){
                    ans /= pq.poll();
                    ans *= num;
                    pq.add(num);
                }
                else{
                    pq.poll();
                }
                System.out.println(ans);
            }
        }
    }
}