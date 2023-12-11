import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> vector = new ArrayDeque<>();
        for(int i = 1 ; i <= N ; i++){
            vector.addLast(i);
        }

        while(vector.size() != 1){
            vector.pollFirst();
            vector.addLast(vector.pollFirst());
        }
        System.out.println(vector.pollLast());
    }
}