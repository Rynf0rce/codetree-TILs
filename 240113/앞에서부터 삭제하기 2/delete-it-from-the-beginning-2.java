import java.util.*;

public class Main {
    public static final int MAX_INPUT_NUM = 100000;
    public static int[] arr = new int[MAX_INPUT_NUM];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        float output = 0;

        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1 ; i <= N - 2 ; i++){
            pq.clear();
            float average = 0;
            for(int j = i ; j < N ; j++){
                average += arr[j];
                pq.add(arr[j]);
            }
            average -= pq.poll();
            average /= pq.size();
            if(output < average){
                output = average;
            }
        }

        System.out.printf("%.2f", output);
    }
}