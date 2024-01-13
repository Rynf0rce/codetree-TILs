import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            pq.add(num * -1);
        }

        for(int i = 0 ; i < m ; i++){
            int maxVal = pq.poll() * - 1 - 1;
            pq.add(maxVal * -1);
        }

        System.out.println(pq.poll() * -1);
    }
}