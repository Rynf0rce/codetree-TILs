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


        int minVal = 0;
        while(!pq_B.isEmpty()){
            int val_B = pq_B.poll();
            minVal = val_B * pq_A.peek();

            while(calculated.peek() != null && calculated.peek() <= minVal){
                if(k == 1){
                    System.out.println(calculated.poll());
                    System.exit(0);
                    break;
                }
                else{
                    calculated.poll();
                }
                k--;
            }

            for(int val_A : pq_A){
                calculated.add(val_A + val_B);
            }
        }

        while(k-- > 1){
            calculated.poll();
        }

        System.out.println(calculated.poll());
    }
}