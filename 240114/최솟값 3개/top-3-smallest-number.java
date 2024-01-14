import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            Long num = sc.nextLong();
            pq.add(num);

            if(pq.size() < 3){
                System.out.println(-1);
                continue;
            }
            else if(pq.size() > 3){
                pq.poll();
            }

            long output = 1;
            for(Long minVal : pq){
                output *= minVal;
            }
            System.out.println(output);
        }
    }
}