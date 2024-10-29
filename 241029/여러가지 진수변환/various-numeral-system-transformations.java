import java.util.*;
public class Main {
    public static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        while(N > 0){
            int num = N % B;
            N = N / B;
            s.push(num);
        }

        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
    }
}