import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] arrA = new int[MAX_LENGTH];
    public static int[] arrB = new int[MAX_LENGTH];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            arrA[i] = sc.nextInt();
        }
        Arrays.sort(arrA, 0, n);

        for(int i = 0 ; i < m ; i++){
            arrB[i] = sc.nextInt();
        }
        Arrays.sort(arrB, 0, m);

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int num = arrB[i] + arrA[j];
                if(pq.size() >= k && !pq.isEmpty() && num > pq.peek()){
                    break;
                }
                pq.add(num);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        System.out.println(pq.peek());
    }
}