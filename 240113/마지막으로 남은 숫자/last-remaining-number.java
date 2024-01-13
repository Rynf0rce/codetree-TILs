import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            pq.add(num * -1);
        }

        while(pq.size() >= 2){
            int largestVal = pq.poll();
            int secLargestVal = pq.poll();

            if(largestVal == secLargestVal){
                continue;
            }

            pq.add(largestVal - secLargestVal);
        }

        System.out.print(pq.isEmpty() ? -1 : pq.poll() * -1);
    }
}