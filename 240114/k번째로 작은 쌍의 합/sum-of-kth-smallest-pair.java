import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100000;

    public static PriorityQueue<Integer> pq_A = new PriorityQueue<>();
    public static PriorityQueue<Integer> pq_B = new PriorityQueue<>();

    public static PriorityQueue<Integer> calculated = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            pq_A.add(num);
        }

        for(int i = 0 ; i < m ; i++){
            int num = sc.nextInt();
            pq_B.add(num);
        }

        while(k > 0){
            int minVal = 0;
            if(pq_A.peek() <= pq_B.peek()){
                minVal = pq_A.poll();
                for(int val_B : pq_B){
                    calculated.add(minVal + val_B);
                }
            }
            else{
                minVal = pq_B.poll();
                for(int val_A : pq_A){
                    calculated.add(minVal + val_A);
                }
            }

            if(k == 1){
                System.out.println(calculated.poll());
            }
            else{
                calculated.poll();
            } 
            k--;
        }
    }
}