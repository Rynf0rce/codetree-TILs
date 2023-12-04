// 기하하적으로 문제 풀이
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
        int sum = b - a + d - c;
        if(c >= a && d <= b ){
            sum -= (d - c);
        }
        else if(c <= a  && b <= d){
            sum -= (b - a);
        }
        else if(c > a && b > c){
            sum -= (b - c);
        }
        else if(a > c && d > a){
            sum -= (d - a);
        }
        System.out.println(sum);
    }
}
/*
import java.util.Scanner;

public class Main {
    public static int a, b, c, d;
    
    public static boolean intersecting(int x1, int x2, int x3, int x4) {
        // 겹치지 않는 경우에 대한 처리를 먼저 진행합니다.
        if(x2 < x3 || x4 < x1)
            return false;
        // 나머지는 전부 겹치는 경우라고 볼 수 있습니다.
        else
            return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        // 겹치는지를 확인합니다.
        if(intersecting(a, b, c, d)) {
            // 만약 겹치는 부분이 있다면,
            // 두 구역들 중 가장 큰 구역에서 가장 작은 구역을 빼면
            // 오늘 몇 구역이나 청소됐는지 알 수 있습니다.
            System.out.print(Math.max(b, d) - Math.min(a, c));
        }
        else {
            // 만약 겹치는 부분이 없다면,
            // 두 구역들을 전부 더하면
            // 오늘 몇 구역이나 청소됐는지 알 수 있습니다.
            System.out.print((b - a) + (d - c));
        }
    }
}
*/
