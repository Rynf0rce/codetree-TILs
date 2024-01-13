import java.util.*;

public class Main {
    public static final int MAX_INPUT_NUM = 100000;
    public static int[] arr = new int[MAX_INPUT_NUM];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        float output = 0;
        float average = 0;
        float sum = 0;

        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        pq.add(arr[N - 1]);
        sum = arr[N - 1];

        for(int i = N - 2 ; i >= 0 ; i--){
            pq.add(arr[i]);
            sum += arr[i];
            average = (sum - pq.peek()) / (pq.size() - 1);
            if(average > output){
                output = average;
            }
        }

        System.out.printf("%.2f", output); 
    }
}