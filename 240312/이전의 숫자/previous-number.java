import java.util.*;

public class Main {
    public static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int num = sc.nextInt();
            if(num == 0){
                break;
            }
            q.add(num);
            if(q.size() == 6){
                q.poll();
            }
        }

        int sum = 0;
        while(!q.isEmpty()){
            sum += q.poll();
        }
        System.out.print(sum);
    }
}