import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            pq.add(num);
            if(pq.size() < 3){
                System.out.println(-1);
            }
            else{
                Iterator iter = pq.iterator();
                int cnt = 0;
                int output = 1;
                while(cnt < 3){
                    output *= (int)iter.next();
                    cnt++;
                }
                System.out.println(output);
            }
        }
    }
}