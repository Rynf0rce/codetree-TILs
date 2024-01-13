import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = sc.nextInt();
        for(int i = 0 ; i < N ; i++){
            String str = sc.next();
            switch(str){
                case("push") :
                    int num = sc.nextInt();
                    pq.add(num * -1);
                    break;
                case("pop") :
                    System.out.println(pq.poll() * -1);
                    break;
                case("size") :
                    System.out.println(pq.size());
                    break;
                case("empty") :
                    System.out.println(pq.isEmpty() ? 1 : 0);
                    break;
                case("top") :
                    System.out.println(pq.peek() * -1);
                    break;
            }
        }
    }
}