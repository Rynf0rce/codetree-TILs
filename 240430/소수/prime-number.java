import java.util.*;

public class Main {
    public static final int MAX_LENGTH = 10000;
    public static boolean[] primeArr = new boolean[MAX_LENGTH + 1];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int i = 2 ; i <= b ; i++){
            if(primeArr[i]){
                continue;
            }

            if(a <= i && i <= b){
                pq.add(i);
            }

            for(int j = 2 * i ; j <= b ; j += i){
                primeArr[j] = true;
            }
        }

        if(pq.isEmpty()){
            System.out.println(-1);
        }
        else{
            int minVal = pq.peek();
            int ans = 0;
            while(!pq.isEmpty()){
                ans += pq.poll();
            }
            System.out.println(ans);
            System.out.print(minVal);
        }
    }
}