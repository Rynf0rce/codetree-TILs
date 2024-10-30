import java.util.*;
public class Main {
    public static PriorityQueue<Character> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for(int i = 0 ; i < str.length() ; i++){
            pq.add(str.charAt(i));
        }
        while(!pq.isEmpty()){
            System.out.print(pq.poll());
        }
    }
}