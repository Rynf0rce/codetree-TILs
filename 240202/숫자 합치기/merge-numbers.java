import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            pq.add(num);
        }

        int cost = 0;
        while(pq.size() > 1){
            int preNum = pq.poll();
            int postNum = pq.poll();

            cost += preNum + postNum;

            pq.add(preNum + postNum);
        }

        System.out.println(cost);        
    }
}