import java.util.*;

public class Main {
    public static Queue<Integer> vector = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt(), cnt = 1;
        for(int i = 1 ; i <= N ; i++){
            vector.add(i);
        }

        while(vector.size() != 1){
            if(cnt == K){
                cnt = 0;
                System.out.print(vector.poll() + " ");
            }
            else{
                vector.add(vector.peek());
                vector.poll();
            }
            cnt++;
        }
        System.out.print(vector.poll());
    }
}