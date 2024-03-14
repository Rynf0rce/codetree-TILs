import java.util.*;

public class Main {
    public static boolean inRange(int start, int end, int point){
        if(start > end){
            return inRange(end, start, point);
        }
        return start <= point && point <= end;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int pos = A;
        int dist = 1;
        int ans = 0;

        while(!inRange(pos, A + dist, B)){
            int goal = A + dist;
            ans += Math.abs(pos - goal);
            pos = goal;
            dist *= -2;
        }

        System.out.print(ans + Math.abs(pos - B));
    }
}