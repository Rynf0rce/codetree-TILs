import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int pos = A;
        int dist = 1;
        int ans = 0;
        while(A + dist <= B){
            int goal = A + dist;
            ans += Math.abs(pos - goal);
            pos = goal;
            dist *= -2;
        }

        System.out.print(ans + Math.abs(pos - B));
    }
}